package com.company.TicTacToe.GameOverRules.WinnerRule;

import com.company.Core.GameOverRules.GameOverRule;

public class WinnerRule implements GameOverRule {

    private final HasWinnerProvider provider;

    public WinnerRule(HasWinnerProvider provider) {
        this.provider = provider;
    }

    public boolean isGameOver() {
        return provider.hasWinner();
    }
}
