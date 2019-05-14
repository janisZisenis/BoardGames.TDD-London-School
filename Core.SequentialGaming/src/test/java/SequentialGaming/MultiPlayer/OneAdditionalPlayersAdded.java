package SequentialGaming.MultiPlayer;

import SequentialGaming.GameFacade.PlayerSpy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OneAdditionalPlayersAdded {

    private PlayerSpy first = new PlayerSpy();
    private MultiPlayerMessengerDummy messenger = new MultiPlayerMessengerDummy();
    private MultiPlayer sut = new MultiPlayer(first, messenger);

    private PlayerSpy second = new PlayerSpy();
    
    @BeforeEach
    void Setup() {
        sut.add(second);
    }

    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheFirstOnce() {
        sut.play();
        sut.play();

        assertHasPlayedTimes(first, 1);
    }

    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheSecondOnce() {
        sut.play();
        sut.play();

        assertHasPlayedTimes(second, 1);
    }

    @Test
    void IfGetsPlayedFourTimes_ShouldHavePlayedTheSecondTwice() {
        sut.play();
        sut.play();
        sut.play();
        sut.play();

        assertHasPlayedTimes(second, 2);
    }

    private void assertHasPlayedTimes(PlayerSpy p, int expected) {
        int actual = p.getPlayedTimes();
        assertEquals(expected, actual);
    }

}
