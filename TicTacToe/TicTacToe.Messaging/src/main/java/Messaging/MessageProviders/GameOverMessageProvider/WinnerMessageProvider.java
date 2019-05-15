package Messaging.MessageProviders.GameOverMessageProvider;

public interface WinnerMessageProvider {
    boolean hasWinner();
    String getWinningMessage();

    class NoWinnerAvailable extends RuntimeException {}
}
