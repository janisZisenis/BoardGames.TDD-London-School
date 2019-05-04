package Domain.GameEvaluation.GameEvaluator.Api;

import Domain.Board.Mark;

public interface WinnerProvider {
    Mark getWinner();
    boolean hasWinner();
}
