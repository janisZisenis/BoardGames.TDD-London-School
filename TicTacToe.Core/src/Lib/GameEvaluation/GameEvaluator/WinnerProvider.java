package Lib.GameEvaluation.GameEvaluator;

import Lib.Board.Mark;

public interface WinnerProvider {
    Mark getWinner();
    boolean hasWinner();
}
