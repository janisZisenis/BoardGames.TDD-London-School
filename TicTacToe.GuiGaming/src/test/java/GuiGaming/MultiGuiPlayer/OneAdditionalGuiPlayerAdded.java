package GuiGaming.MultiGuiPlayer;

import InputGeneration.Input.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OneAdditionalGuiPlayerAdded {

    private GuiPlayerSpy first = new GuiPlayerSpy();
    private MultiGuiPlayer sut = new MultiGuiPlayer(first);

    private GuiPlayerSpy second = new GuiPlayerSpy();
    private Input input = new Input(0, 0);

    @BeforeEach
    void SetUp() {
        sut.add(second);
    }


    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheFirstOnce() {
        sut.play(input);
        sut.play(input);

        assertHasPlayedTimes(first, 1);
    }

    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheSecondOnce() {
        sut.play(input);
        sut.play(input);

        assertHasPlayedTimes(second, 1);
    }

    @Test
    void IfGetsPlayedFourTimes_ShouldHavePlayedTheSecondTwice() {
        sut.play(input);
        sut.play(input);
        sut.play(input);
        sut.play(input);

        assertHasPlayedTimes(second, 2);
    }

    private void assertHasPlayedTimes(GuiPlayerSpy p, int expected) {
        int actual = p.getPlayedTimes();
        assertEquals(expected, actual);
    }

}
