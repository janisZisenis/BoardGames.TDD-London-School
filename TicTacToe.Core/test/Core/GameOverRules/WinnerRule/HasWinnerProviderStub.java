package Core.GameOverRules.WinnerRule;

public class HasWinnerProviderStub implements HasWinnerProvider {
    boolean hasWinner = false;

    public void setHasWinner(boolean hasWinner) {
        this.hasWinner = hasWinner;
    }

    public boolean hasWinner() {
        return this.hasWinner;
    }
}
