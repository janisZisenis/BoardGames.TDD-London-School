package com.company.TicTacToe.GameOverRules.WinnerRule;


import com.company.Core.GameOverRules.GameOverRule;
import com.company.TicTacToe.Line;
import com.company.TicTacToe.TicTacToeWinningLineProvider.LineEvaluator;
import com.company.TicTacToe.TicTacToeWinningLineProvider.LineProvider;

public class WinningLineRule implements GameOverRule {
    private final LineProvider provider;
    private final LineEvaluator evaluator;

    public WinningLineRule(LineProvider provider, LineEvaluator evaluator) {
        this.provider = provider;
        this.evaluator = evaluator;
    }

    public boolean isGameOver() {

        for(int i = 0; i < provider.getLineCount(); i++) {
            Line line = provider.getLine(i);
            if (evaluator.isWinningLine(line)) {
                return true;
            }
        }

        return false;
    }
}
