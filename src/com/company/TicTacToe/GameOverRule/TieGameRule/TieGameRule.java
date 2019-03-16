package com.company.TicTacToe.GameOverRule.TieGameRule;

import com.company.TicTacToe.Constants.BoardBoundaries;

public class TieGameRule {

    private final int fieldCount = BoardBoundaries.fieldCount;
    private final MarkedFieldCountProvider provider;

    public TieGameRule(MarkedFieldCountProvider provider) {
        this.provider = provider;
    }

    public boolean hasMovesLeft() {
        return provider.getMarkedFieldCount() < fieldCount;
    }

}
