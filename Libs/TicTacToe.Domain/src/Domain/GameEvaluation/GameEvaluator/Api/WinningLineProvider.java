package Domain.GameEvaluation.GameEvaluator.Api;

import Data.Line.Line;

public interface WinningLineProvider {
    boolean hasWinningLine();
    Line getWinningLine();

    class NoWinningLineAvailable extends RuntimeException {}
    class NoWinnerAvailable extends RuntimeException {}
}
