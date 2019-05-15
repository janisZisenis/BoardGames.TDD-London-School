package Domain.GameEvaluation.GameEvaluator.Api;

import Domain.Data.Mark;

public interface WinnerProvider {
    Mark getWinner();
    boolean hasWinner();
}
