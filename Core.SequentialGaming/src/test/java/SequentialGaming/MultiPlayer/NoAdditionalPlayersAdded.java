package SequentialGaming.MultiPlayer;

import SequentialGaming.DelegatingGame.PlayerSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NoAdditionalPlayersAdded {

    private PlayerSpy player = new PlayerSpy();
    private MultiPlayerMessengerDummy messenger = new MultiPlayerMessengerDummy();
    private MultiPlayer sut = new MultiPlayer(player, messenger);

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


    private void assertHasPlayedTimes(int expected) {
        int actual = player.getPlayedTimes();
        assertEquals(expected, actual);
    }

}
