package com.company.Presentation.LeaveTaker;

import com.company.Data.Mark;

public class WinnerProviderStub implements WinnerProvider {

    private Mark winner;

    public void setWinner(Mark winner) {
        this.winner = winner;
    }
    public boolean hasWinner() {
        return winner != null;
    }
    public Mark getWinner() {
        return winner;
    }
}
