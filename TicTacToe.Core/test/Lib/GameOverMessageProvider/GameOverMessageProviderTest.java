package Lib.GameOverMessageProvider;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverMessageProviderTest {

    private WinnerMessageProviderStub provider = new WinnerMessageProviderStub();

    @Test
    void IfNoWinnerIsProvided_ShouldProvideTheDrawMessage() {
        GameOverMessageProvider sut = new GameOverMessageProvider(provider, "DrawMessage");
        provider.setHasWinner(false);

        String actual = sut.getGameOverMessage();
        String expected = "DrawMessage";
        assertEquals(expected, actual);
    }

    @Test
    void IfWinnerIsProvided_ShouldProvideTheWinningMessage() {
        GameOverMessageProvider sut = new GameOverMessageProvider(provider, "");
        provider.setHasWinner(true);
        provider.setWinningMessage("WinningMessage");

        String actual = sut.getGameOverMessage();
        String expected = "WinningMessage";
        assertEquals(expected, actual);
    }

}
