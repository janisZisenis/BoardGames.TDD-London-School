package Gaming.MultiPlayer;

import Gaming.GameFacade.PlayerDummy;
import Gaming.GameFacade.PlayerMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TwoAdditionalPlayersAdded {

    private PlayerDummy first = new PlayerDummy();
    private MultiPlayerMessengerDummy messenger = new MultiPlayerMessengerDummy();
    private MultiPlayer sut = new MultiPlayer(first, messenger);

    private PlayerDummy second = new PlayerDummy();
    private PlayerMock third = new PlayerMock();

    @BeforeEach
    void Setup() {
        sut.add(second);
        sut.add(third);
    }

    @Test
    void IfGetsPlayedThreeTimes_ShouldHavePlayedTheThirdOnce() {
        third.expectGetsPlayedTimes(1);

        sut.play();
        sut.play();
        sut.play();

        third.verifyAll();
    }

}
