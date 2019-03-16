package com.company.TicTacToe.GameOverRules.NumberOfMovesRule;

import com.company.Core.CompositeGameOverRule.GameOverRule;
import com.company.TicTacToe.Constants.BoardBoundaries;

public class NumberOfMovesRule implements GameOverRule {

    private final int fieldCount = BoardBoundaries.fieldCount;
    private final MarkedFieldCountProvider provider;

    public NumberOfMovesRule(MarkedFieldCountProvider provider) {
        this.provider = provider;
    }

    public boolean isGameOver() {
        return provider.getMarkedFieldCount() >= fieldCount;
    }

}
