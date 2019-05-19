package MessageProviders.GameOverMessageProvider;

import GameLoopMessengerImp.MessageProvider;

public class GameOverMessageProvider implements MessageProvider {

    private final WinnerMessageProvider winnerProvider;
    private final MessageProvider drawProvider;

    public GameOverMessageProvider(WinnerMessageProvider winnerProvider, MessageProvider drawProvider) {
        this.winnerProvider = winnerProvider;
        this.drawProvider = drawProvider;
    }

    public String getMessage() {
        if(winnerProvider.hasWinner())
            return winnerProvider.getWinningMessage();

        return drawProvider.getMessage();
    }
}
