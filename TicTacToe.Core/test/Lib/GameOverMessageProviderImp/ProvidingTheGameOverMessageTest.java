package Lib.GameOverMessageProviderImp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProvidingTheGameOverMessageTest {

    private WinnerMessageProviderStub provider = new WinnerMessageProviderStub();

    @Test
    void IfNoWinnerIsProvided_ShouldProvideTheDrawMessage() {
        GameOverMessageProviderImp sut = new GameOverMessageProviderImp(provider, "DrawMessage");
        provider.setHasWinner(false);

        String actual = sut.getGameOverMessage();
        String expected = "DrawMessage";
        assertEquals(expected, actual);
    }

    @Test
    void IfWinnerIsProvided_ShouldProvideTheWinningMessage() {
        GameOverMessageProviderImp sut = new GameOverMessageProviderImp(provider, "");
        provider.setHasWinner(true);
        provider.setWinningMessage("WinningMessage");

        String actual = sut.getGameOverMessage();
        String expected = "WinningMessage";
        assertEquals(expected, actual);
    }

}
