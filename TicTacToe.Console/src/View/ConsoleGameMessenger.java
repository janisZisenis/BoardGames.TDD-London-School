package View;

import Lib.GameOverMessageProviderImp.GameOverMessageProvider;
import Lib.Games.MessagingGame.GameMessenger;

public class ConsoleGameMessenger implements GameMessenger {

    private final String beginningMessage = "Welcome To TicTacToe!";
    private final GameOverMessageProvider provider;

    public ConsoleGameMessenger(GameOverMessageProvider provider) {
        this.provider = provider;
    }

    public void publishBeginningMessage() {
        System.out.println(beginningMessage);
    }

    public void publishGameOverMessage() {
        String message = provider.getGameOverMessage();
        System.out.println(message);
    }

}
