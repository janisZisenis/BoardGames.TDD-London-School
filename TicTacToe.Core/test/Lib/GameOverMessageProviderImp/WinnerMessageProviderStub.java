package Lib.GameOverMessageProviderImp;

public class WinnerMessageProviderStub implements WinnerMessageProvider {
    private boolean hasWinner = false;
    private String winningMessage;

    public void setHasWinner(boolean hasWinner) {
        this.hasWinner = hasWinner;
    }
    public boolean hasWinner() {
        return this.hasWinner;
    }

    public void setWinningMessage(String winningMessage) {
        this.winningMessage = winningMessage;
    }
    public String getWinningMessage() {
        return this.winningMessage;
    }

}
