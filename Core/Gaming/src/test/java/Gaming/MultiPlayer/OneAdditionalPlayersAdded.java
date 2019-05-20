package Gaming.MultiPlayer;

import Gaming.GameFacade.PlayerMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OneAdditionalPlayersAdded {

    private PlayerMock first = new PlayerMock();
    private MultiPlayerMessengerDummy messenger = new MultiPlayerMessengerDummy();
    private MultiPlayer sut = new MultiPlayer(first, messenger);

    private PlayerMock second = new PlayerMock();
    
    @BeforeEach
    void Setup() {
        sut.add(second);
    }

    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheFirstOnce() {
        first.expectGetsPlayedTimes(1);

        sut.play();
        sut.play();

        first.verifyAll();
    }

    @Test
    void IfGetsPlayedTwice_ShouldHavePlayedTheSecondOnce() {
        second.expectGetsPlayedTimes(1);

        sut.play();
        sut.play();

        second.verifyAll();
    }

    @Test
    void IfGetsPlayedFourTimes_ShouldHavePlayedTheSecondTwice() {
        second.expectGetsPlayedTimes(2);

        sut.play();
        sut.play();
        sut.play();
        sut.play();

        second.verifyAll();
    }

}
