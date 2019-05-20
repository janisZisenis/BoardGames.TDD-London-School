package Gaming.MultiPlayer;

import Gaming.GameFacade.PlayerMock;
import org.junit.jupiter.api.Test;

public class NoAdditionalPlayersAdded {

    private PlayerMock player = new PlayerMock();
    private MultiPlayerMessengerDummy messenger = new MultiPlayerMessengerDummy();
    private MultiPlayer sut = new MultiPlayer(player, messenger);

    @Test
    void IfGetsPlayedOnce_ShouldHavePlayedTheFirstOnce() {
        player.expectGetsPlayedTimes(1);

        sut.play();

        player.verifyAll();
    }

    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheFirstTwice() {
        player.expectGetsPlayedTimes(2);

        sut.play();
        sut.play();

        player.verifyAll();
    }

    @Test
    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheFirstThreeTimes() {
        player.expectGetsPlayedTimes(3);

        sut.play();
        sut.play();
        sut.play();

        player.verifyAll();
    }

}
