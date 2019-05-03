package Lib.GameOverMessageProviderImp;

public interface WinnerMessageProvider {
    boolean hasWinner();
    String getWinningMessage();

    class NoWinnerAvailable extends RuntimeException {}
}
