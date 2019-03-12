package com.company.TicTacToe.GameOver.NumberOfMovesReferee;

import com.company.TicTacToe.Constants.BoardBoundaries;

public class NumberOfMovesReferee {

    private final int fieldCount = BoardBoundaries.fieldCount;
    private final MarkedFieldCountProvider provider;

    public NumberOfMovesReferee(MarkedFieldCountProvider provider) {
        this.provider = provider;
    }

    public boolean hasMovesLeft() {
        return provider.getMarkedFieldCount() < fieldCount;
    }

}
