package com.company.TicTacToe.GameOver.GameHasWinnerReferee;

import com.company.TicTacToe.Line;

public interface LineEvaluator {
    boolean isWinningLine(Line line);
}
