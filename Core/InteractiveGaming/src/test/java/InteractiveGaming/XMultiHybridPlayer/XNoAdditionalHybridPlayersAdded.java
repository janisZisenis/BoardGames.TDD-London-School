package InteractiveGaming.XMultiHybridPlayer;

import Input2D.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class XNoAdditionalHybridPlayersAdded {

    private XHybridPlayerSpy first = new XHybridPlayerSpy();
    private XMultiHybridPlayer sut = new XMultiHybridPlayer(first);

    @Test
    void IfGetsPlayedOnce_ShouldHavePlayedTheFirstOnce() {
        sut.play();

        assertTimesPlayed(1);
    }

    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheFirstTwice() {
        sut.play();
        sut.play();

        assertTimesPlayed(2);
    }

    @Test
    void IfGetsPlayedFourTimes_ShouldHavePlayedTheFirstFourTimes() {
        sut.play();
        sut.play();
        sut.play();
        sut.play();

        assertTimesPlayed(4);
    }

    private void assertTimesPlayed(int expected) {
        int actual = first.getTimesPlayedWithoutInput();
        assertEquals(expected, actual);
    }


    @Test
    void IfInputGetsPlayed_ShouldPlayInputInputEither() {
        Input input = new Input(0, 0);

        sut.playInput(input);

        assertPlayedInputEquals(input);
    }

    private void assertPlayedInputEquals(Input expected) {
        Input actual = first.getPlayedInput();
        assertEquals(expected, actual);
    }


    @Test
    void IfFirstIsInputTurn_ShouldBeInputTurnEither() {
        first.setIsInputTurn(true);

        assertIsInputTurn();
    }

    private void assertIsInputTurn() {
        boolean actual = sut.isInputTurn();
        assertTrue(actual);
    }

    @Test
    void IfFirstIsComputer_ShouldBeComputerEither() {
        first.setIsInputTurn(false);

        assertIsNotInputTurn();
    }

    private void assertIsNotInputTurn() {
        boolean actual = sut.isInputTurn();
        assertFalse(actual);
    }

}
