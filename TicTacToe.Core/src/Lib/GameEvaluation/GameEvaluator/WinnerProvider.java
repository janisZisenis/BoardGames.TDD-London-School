package Lib.GameEvaluation.GameEvaluator;

import Lib.Data.Mark;

public interface WinnerProvider {
    Mark getWinner();
    boolean hasWinner();
}
