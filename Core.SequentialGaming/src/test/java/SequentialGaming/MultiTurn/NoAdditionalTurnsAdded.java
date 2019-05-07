package SequentialGaming.MultiTurn;

import SequentialGaming.DelegatingGame.TurnSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoAdditionalTurnsAdded {

    private TurnSpy first = new TurnSpy();
    private MultiTurn sut = new MultiTurn(first);

    @Test
    void IfGetsPlayedOnce_ShouldHavePlayedTheFirstOnce() {
        sut.play();

        assertHasPlayedTimes(1);
    }

    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheFirstTwice() {
        sut.play();
        sut.play();

        assertHasPlayedTimes(2);
    }

    @Test
    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheFirstThreeTimes() {
        sut.play();
        sut.play();
        sut.play();

        assertHasPlayedTimes(3);
    }

    @Test
    void IfGetsPlayedFourTimes_ShouldhavePlayedTheFirstFourTimes() {
        sut.play();
        sut.play();
        sut.play();
        sut.play();

        assertHasPlayedTimes(4);
    }

    private void assertHasPlayedTimes(int expected) {
        int actual = first.getPlayedTimes();
        assertEquals(expected, actual);
    }

}
