package com.company.TicTacToe.CountingReferee;

import com.company.TicTacToe.Constants.BoardBoundaries;

public class CountingReferee {

    private final int fieldCount = BoardBoundaries.fieldCount;
    private final MarkedFieldCountProvider provider;

    public CountingReferee(MarkedFieldCountProvider provider) {
        this.provider = provider;
    }

    public boolean hasMovesLeft() {
        return provider.getMarkedFieldCount() < fieldCount;
    }

}
