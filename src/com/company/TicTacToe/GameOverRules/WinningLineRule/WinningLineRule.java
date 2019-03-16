package com.company.TicTacToe.GameOverRules.WinningLineRule;


import com.company.Core.CompositeGameOverRule.GameOverRule;
import com.company.TicTacToe.Line;

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
