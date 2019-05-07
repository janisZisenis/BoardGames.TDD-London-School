package Messaging.tested.MessageProviders.GameOverMessageProvider;

public interface WinnerMessageProvider {
    boolean hasWinner();
    String getWinningMessage();

    class NoWinnerAvailable extends RuntimeException {}
}
