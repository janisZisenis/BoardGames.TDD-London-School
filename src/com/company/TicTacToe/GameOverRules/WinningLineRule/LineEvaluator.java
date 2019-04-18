package com.company.TicTacToe.GameOverRules.WinningLineRule;

import com.company.TicTacToe.Line;

public interface LineEvaluator {
    boolean isWinningLine(Line line);

    class NoWinnerForLineAvailable extends RuntimeException {}
}
