package Messaging.tested.MessageProviders.GameOverMessageProvider;

import Messaging.tested.GameLoopMessengerImp.MessageProvider;

public class GameOverMessageProvider {

    private final WinnerMessageProvider winnerProvider;
    private final MessageProvider drawProvider;

    public GameOverMessageProvider(WinnerMessageProvider winnerProvider, MessageProvider drawProvider) {
        this.winnerProvider = winnerProvider;
        this.drawProvider = drawProvider;
    }

    public String getGameOverMessage() {
        if(winnerProvider.hasWinner())
            return winnerProvider.getWinningMessage();

        return drawProvider.getMessage();
    }
}
