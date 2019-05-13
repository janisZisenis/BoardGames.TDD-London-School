package GuiGaming.MultiGuiPlayer;

import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoAdditionalGuiPlayersAdded {

    private GuiPlayerSpy first = new GuiPlayerSpy();
    private MultiGuiPlayer sut = new MultiGuiPlayer(first);

    private Input input = new Input(0, 0);

    @Test
    void IfGetsPlayedOnce_ShouldHavePlayedTheFirstOnce() {
        sut.play(input);

        assertPlayedTimes(1);
    }

    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheFirstTwice() {
        sut.play(input);
        sut.play(input);

        assertPlayedTimes(2);
    }

    @Test
    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheFirstThreeTimes() {
        sut.play(input);
        sut.play(input);
        sut.play(input);

        assertPlayedTimes(3);
    }

    @Test
    void IfGetsPlayedFourTimes_ShouldHavePlayedTheFirstFourTimes() {
        sut.play(input);
        sut.play(input);
        sut.play(input);
        sut.play(input);

        assertPlayedTimes(4);
    }

    private void assertPlayedTimes(int expected) {
        int actual = first.getPlayedTimes();
        assertEquals(expected, actual);
    }

}
