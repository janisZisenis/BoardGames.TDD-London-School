package com.company.TicTacToe.LeaveTaking;

import com.company.LeaveTaking.WinnerProvider;
import com.company.TicTacToe.Board.Mark;

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
