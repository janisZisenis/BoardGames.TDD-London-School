package Lib.GameEvaluation;

import Lib.Data.Mark;

public interface WinnerProvider {
    Mark getWinner();
    boolean hasWinner();
}
