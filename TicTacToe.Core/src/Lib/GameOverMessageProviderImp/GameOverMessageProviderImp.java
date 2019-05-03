package Lib.GameOverMessageProviderImp;

public class GameOverMessageProviderImp implements GameOverMessageProvider {

    private final String drawMessage;
    private final WinnerMessageProvider provider;

    public GameOverMessageProviderImp(WinnerMessageProvider provider, String drawMessage) {
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
