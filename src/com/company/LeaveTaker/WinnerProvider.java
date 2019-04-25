package com.company.LeaveTaker;

import com.company.TicTacToe.Board.Mark;

public interface WinnerProvider {
    Mark getWinner();
    boolean hasWinner();
}
