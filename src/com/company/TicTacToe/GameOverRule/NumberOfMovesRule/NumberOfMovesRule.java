package com.company.TicTacToe.GameOverRule.NumberOfMovesRule;

import com.company.TicTacToe.Constants.BoardBoundaries;

public class NumberOfMovesRule {

    private final int fieldCount = BoardBoundaries.fieldCount;
    private final MarkedFieldCountProvider provider;

    public NumberOfMovesRule(MarkedFieldCountProvider provider) {
        this.provider = provider;
    }

    public boolean hasMoveLeft() {
        return provider.getMarkedFieldCount() < fieldCount;
    }

}
