package com.company.TicTacToe.GameOverRules.WinnerRule;

public class HasWinnerRule {

    private final HasWinnerProvider provider;

    public HasWinnerRule(HasWinnerProvider provider) {
        this.provider = provider;
    }

    public boolean isGameOver() {
        return provider.hasWinner();
    }
}
