package Lib.Model.GameOverRules.NumberOfMovesRule;

import Lib.Data.BoardBoundaries;
import Lib.Model.SelfActingGameLoop.GameOverRule;

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
