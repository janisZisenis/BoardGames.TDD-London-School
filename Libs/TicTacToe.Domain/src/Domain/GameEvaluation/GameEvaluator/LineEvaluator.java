package Domain.GameEvaluation.GameEvaluator;

import Domain.Data.Line.Line;
import Domain.Board.Mark;

public interface LineEvaluator {
    boolean isWinningLine(Line line);
    Mark getWinner(Line line);

    class NoWinnerForLineAvailable extends RuntimeException {}
}
