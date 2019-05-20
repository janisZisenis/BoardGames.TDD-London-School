package InteractiveGaming.MultiHybridPlayer;

import InteractiveGaming.HybridGameImp.HybridPlayerSpy;
import Input2D.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoAdditionalHybridPlayersAdded {

    private HybridPlayerSpy first = new HybridPlayerSpy();
    private MultiHybridPlayer sut = new MultiHybridPlayer(first);

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
    void IfInputR0C0GetsPlayed_ShouldPlayInputR0C0Either() {
        Input input = new Input(0, 0);

        sut.playInput(input);

        assertPlayedInputEquals(new Input(0, 0));
    }

    @Test
    void IfInputR1C2GetsPlayed_ShouldPlayInputR1C2Either() {
        Input input = new Input(1, 2);

        sut.playInput(input);

        assertPlayedInputEquals(new Input(1, 2));
    }

    private void assertPlayedInputEquals(Input expected) {
        Input actual = first.getPlayedInput();
        assertEquals(expected, actual);
    }


    @Test
    void IfFirstIsNotComputer_ShouldBeNotComputerEither() {
        first.setTimesPlayableWithoutInput(0);

        assertIsNotComputer();
    }

    private void assertIsNotComputer() {
        boolean actual = sut.isNotInputTurn();
        assertFalse(actual);
    }


    @Test
    void IfFirstIsComputer_ShouldBeComputerEither() {
        first.setTimesPlayableWithoutInput(1);

        assertIsComputer();
    }

    private void assertIsComputer() {
        boolean actual = sut.isNotInputTurn();
        assertTrue(actual);
    }

}
