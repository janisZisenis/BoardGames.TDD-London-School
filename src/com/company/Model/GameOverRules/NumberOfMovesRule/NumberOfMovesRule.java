package com.company.Model.GameOverRules.NumberOfMovesRule;

import com.company.Model.GameLoop.GameOverRule;
import com.company.Data.BoardBoundaries;

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
