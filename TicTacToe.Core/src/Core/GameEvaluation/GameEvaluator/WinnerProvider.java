package Core.GameEvaluation.GameEvaluator;

import Board.Mark;

public interface WinnerProvider {
    Mark getWinner();
    boolean hasWinner();
}
