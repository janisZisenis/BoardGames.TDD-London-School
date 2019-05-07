package SequentialGaming.MultiTurn;

import SequentialGaming.DelegatingGame.TurnSpy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoAdditionalTurnsAdded {

    private TurnSpy first = new TurnSpy();
    private MultiTurnMessengerSpy messenger = new MultiTurnMessengerSpy();
    private MultiTurn sut = new MultiTurn(first, messenger);

    private TurnSpy second = new TurnSpy();
    private TurnSpy third = new TurnSpy();

    @BeforeEach
    void Setup() {
        sut.add(second);
        sut.add(third);
    }

    @Test
    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheThirdOnce() {
        sut.play();
        sut.play();
        sut.play();

        int actual = third.getPlayedTimes();
        int expected = 1;
        assertEquals(expected, actual);
    }


    @Test
    void IfGetsPlayedOnce_ShouldHavePublishedTheFirst() {
        sut.play();

        Object actual = messenger.getPublished();
        Object expected = first;
        assertEquals(expected, actual);
    }

}
