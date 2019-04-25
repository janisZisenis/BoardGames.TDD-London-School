package com.company.Model.GameEvaluation.GameEvaluator;

import com.company.Data.Mark;
import com.company.Data.Line;

public interface LineEvaluator {
    boolean isWinningLine(Line line);
    Mark getWinner(Line line);

    class NoWinnerForLineAvailable extends RuntimeException {}
}
