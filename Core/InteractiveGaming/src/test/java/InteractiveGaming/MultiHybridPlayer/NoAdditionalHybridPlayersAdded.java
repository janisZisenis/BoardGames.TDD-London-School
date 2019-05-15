package InteractiveGaming.MultiHybridPlayer;

import InteractiveGaming.HybridGameImp.HybridPlayerSpy;
import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NoAdditionalHybridPlayersAdded {

    private HybridPlayerSpy first = new HybridPlayerSpy();
    private MultiHybridPlayer sut = new MultiHybridPlayer(first);

    @Test
    void IfGetsPlayedOnce_ShouldHavePlayedTheFirstOnce() {
        sut.playComputer();

        assertTimesPlayed(1);
    }

    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheFirstTwice() {
        sut.playComputer();
        sut.playComputer();

        assertTimesPlayed(2);
    }

    @Test
    void IfGetsPlayedFourTimes_ShouldHavePlayedTheFirstFourTimes() {
        sut.playComputer();
        sut.playComputer();
        sut.playComputer();
        sut.playComputer();

        assertTimesPlayed(4);
    }

    private void assertTimesPlayed(int expected) {
        int actual = first.getTimesPlayedComputer();
        assertEquals(expected, actual);
    }


    @Test
    void IfInputR0C0GetsPlayed_ShouldPlayInputR0C0Either() {
        Input input = new Input(0, 0);

        sut.playHuman(input);

        assertPlayedInputEquals(new Input(0, 0));
    }

    @Test
    void IfInputR1C2GetsPlayed_ShouldPlayInputR1C2Either() {
        Input input = new Input(1, 2);

        sut.playHuman(input);

        assertPlayedInputEquals(new Input(1, 2));
    }

    private void assertPlayedInputEquals(Input expected) {
        Input actual = first.getPlayedInput();
        assertEquals(expected, actual);
    }


    @Test
    void IfFirstIsNotComputer_ShouldBeNotComputerEither() {
        first.setTimesIsComputer(0);

        assertIsNotComputer();
    }

    private void assertIsNotComputer() {
        boolean actual = sut.isComputer();
        assertFalse(actual);
    }


    @Test
    void IfFirstIsComputer_ShouldBeComputerEither() {
        first.setTimesIsComputer(1);

        assertIsComputer();
    }

    private void assertIsComputer() {
        boolean actual = sut.isComputer();
        assertTrue(actual);
    }

}
