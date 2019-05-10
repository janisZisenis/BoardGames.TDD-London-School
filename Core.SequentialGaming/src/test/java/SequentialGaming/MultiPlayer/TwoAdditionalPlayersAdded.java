package SequentialGaming.MultiPlayer;

import SequentialGaming.GameFacade.PlayerSpy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoAdditionalPlayersAdded {

    private PlayerSpy first = new PlayerSpy();
    private MultiPlayerMessengerDummy messenger = new MultiPlayerMessengerDummy();
    private MultiPlayer sut = new MultiPlayer(first, messenger);

    private PlayerSpy second = new PlayerSpy();
    private PlayerSpy third = new PlayerSpy();

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

}
