package com.company.TicTacToe.CountingReferee;

import com.company.TicTacToe.Constants.BoardBoundaries;

public class CountingReferee {

    private int numberOfMoves = BoardBoundaries.fieldCount;

    public boolean hasMovesLeft() {
        return numberOfMoves-- >= 1;
    }

}
