package Messaging.Turn.MessagingTurn;

import Core.TwoPlayerTurn.PlayerDummy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TurnMessagingTest {

    private PlayerDummy first = new PlayerDummy();
    private PlayerDummy second = new PlayerDummy();
    private TurnMessengerSpy view = new TurnMessengerSpy();
    private MessagingTwoPlayerTurn sut = new MessagingTwoPlayerTurn(first, second, view);

    @Test
    void IfPlayedOnce_ShouldPublishTurnMessageWithFirstPlayer() {
        sut.play();

        Object actual = view.getPlayerForPublishedTurnMessage();
        Object expected = first;
        assertEquals(expected, actual);
    }

    @Test
    void IfPlayedTwice_ShouldPublishTurnMessageWithSecondPlayer() {
        sut.play();
        sut.play();

        Object actual = view.getPlayerForPublishedTurnMessage();
        Object expected = second;
        assertEquals(expected, actual);
    }

}
