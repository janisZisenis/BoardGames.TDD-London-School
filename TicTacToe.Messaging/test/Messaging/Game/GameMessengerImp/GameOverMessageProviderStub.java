package Messaging.Game.GameMessengerImp;

public class GameOverMessageProviderStub implements GameOverMessageProvider {

    private String gameOverMessage = "";

    public void setGameOverMessage(String message) {
        this.gameOverMessage = message;
    }
    public String getGameOverMessage() {
        return gameOverMessage;
    }
}
