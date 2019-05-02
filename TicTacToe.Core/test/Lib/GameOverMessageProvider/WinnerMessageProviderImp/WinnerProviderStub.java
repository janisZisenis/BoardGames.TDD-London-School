package Lib.GameOverMessageProvider.WinnerMessageProviderImp;

import Lib.Data.Mark;

public class WinnerProviderStub implements WinnerProvider {

    private Mark winner = null;
    private boolean hasWinner = false;

    public void setWinner(Mark winner) {
        this.winner = winner;
    }
    public Mark getWinner() {
        return winner;
    }

    public void setHasWinner(boolean hasWinner) {
        this.hasWinner = hasWinner;
    }
    public boolean hasWinner() {
        return hasWinner;
    }
}
