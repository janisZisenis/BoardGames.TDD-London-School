package Lib.Model.GameEvaluation.GameEvaluator;

import Lib.Data.Line;
import Lib.Data.Mark;

public interface LineEvaluator {
    boolean isWinningLine(Line line);
    Mark getWinner(Line line);

    class NoWinnerForLineAvailable extends RuntimeException {}
}
