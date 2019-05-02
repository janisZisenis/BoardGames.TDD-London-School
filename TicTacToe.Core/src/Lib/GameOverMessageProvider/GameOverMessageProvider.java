package Lib.GameOverMessageProvider;

public class GameOverMessageProvider {

    private final String drawMessage;
    private final WinnerMessageProvider provider;

    public GameOverMessageProvider(WinnerMessageProvider provider, String drawMessage) {
        this.provider = provider;
        this.drawMessage = drawMessage;
    }

    public String getGameOverMessage() {
        if(provider.hasWinner()) {
            return provider.getWinningMessage();
        }
        return drawMessage;
    }
}
