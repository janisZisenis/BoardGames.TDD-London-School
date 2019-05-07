package Messaging.tested.MessageProviders.GameOverMessageProvider;

import Messaging.tested.GameLoopMessengerImp.MessageProviderStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverMessageProviderTest {

    private WinnerMessageProviderStub winnerProvider = new WinnerMessageProviderStub();
    private MessageProviderStub drawProvider = new MessageProviderStub();
    private GameOverMessageProvider sut = new GameOverMessageProvider(winnerProvider, drawProvider);

    @Test
    void IfNoWinnerIsProvided_ShouldProvideTheDrawMessage() {
        winnerProvider.setHasWinner(false);
        drawProvider.setMessage("DrawMessage");

        String actual = sut.getGameOverMessage();
        String expected = "DrawMessage";
        assertEquals(expected, actual);
    }

    @Test
    void IfWinnerIsProvided_ShouldProvideTheWinningMessage() {
        winnerProvider.setHasWinner(true);
        winnerProvider.setWinningMessage("WinningMessage");

        String actual = sut.getGameOverMessage();
        String expected = "WinningMessage";
        assertEquals(expected, actual);
    }

}
