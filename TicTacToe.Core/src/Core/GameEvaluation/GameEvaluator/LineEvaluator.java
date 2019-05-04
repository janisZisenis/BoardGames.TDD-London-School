package Core.GameEvaluation.GameEvaluator;

import Board.Mark;
import Data.Line.Line;

public interface LineEvaluator {
    boolean isWinningLine(Line line);
    Mark getWinner(Line line);

    class NoWinnerForLineAvailable extends RuntimeException {}
}
