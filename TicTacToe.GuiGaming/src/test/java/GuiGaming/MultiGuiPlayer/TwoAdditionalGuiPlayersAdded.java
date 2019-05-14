package GuiGaming.MultiGuiPlayer;

import InputGeneration.Input.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoAdditionalGuiPlayersAdded {

    private GuiPlayerSpy first = new GuiPlayerSpy();
    private MultiGuiPlayer sut = new MultiGuiPlayer(first);

    private GuiPlayerSpy second = new GuiPlayerSpy();
    private GuiPlayerSpy third = new GuiPlayerSpy();

    private Input input = new Input(0, 0);

    @BeforeEach
    void SetUp() {
        sut.add(second);
        sut.add(third);
    }


    @Test
    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheSecondOnce() {
        sut.play(input);
        sut.play(input);

        assertHasPlayedTimes(second, 1);
    }

    @Test
    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheThirdOnce() {
        sut.play(input);
        sut.play(input);
        sut.play(input);

        assertHasPlayedTimes(third, 1);
    }

    private void assertHasPlayedTimes(GuiPlayerSpy p, int expected) {
        int actual = p.getPlayedTimes();
        assertEquals(expected, actual);
    }

}
