package com.company.TicTacToe.LeaveTaker;

import com.company.TicTacToe.Board.Mark;

public interface LeaveTakerView {
    void showWinner(Mark winner);
    void showDraw();
}
