package Domain.GameEvaluation.GameEvaluator;

import Domain.Board.Mark;

public interface WinnerProvider {
    Mark getWinner();
    boolean hasWinner();
}
