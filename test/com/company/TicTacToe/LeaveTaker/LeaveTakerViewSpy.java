package com.company.TicTacToe.LeaveTaker;

import com.company.TicTacToe.Board.Mark;

public class LeaveTakerViewSpy implements LeaveTakerView {

    private Mark showedWinner;
    private boolean didShowDraw = false;
    private boolean didShowWinner = false;

    public void showWinner(Mark winner) {
        didShowWinner = true;
        showedWinner = winner;
    }
    public Mark getShowedWinner() {
        return showedWinner;
    }

    public boolean showedDraw() {
        return didShowDraw;
    }
    public void showDraw() { didShowDraw = true; }

    public boolean hasShowedWinner() {
        return didShowWinner;
    }
}
