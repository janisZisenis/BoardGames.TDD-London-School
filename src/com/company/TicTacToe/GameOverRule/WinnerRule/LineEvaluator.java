package com.company.TicTacToe.GameOverRule.WinnerRule;

import com.company.TicTacToe.Line;

public interface LineEvaluator {
    boolean isWinningLine(Line line);
}
