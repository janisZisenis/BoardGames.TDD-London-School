package com.company.TicTacToe.TicTacToeWinningLineProvider;

import com.company.TicTacToe.BoardPresenter.WinningLineProvider;
import com.company.TicTacToe.GameOverRules.WinningLineRule.LineEvaluator;
import com.company.TicTacToe.GameOverRules.WinningLineRule.LineProvider;
import com.company.TicTacToe.Line;

public class TicTacToeWinningLineProvider implements WinningLineProvider {

    private final LineEvaluator evaluator;
    private final LineProvider provider;

    public TicTacToeWinningLineProvider(LineProvider provider, LineEvaluator evaluator) {
        this.provider = provider;
        this.evaluator = evaluator;
    }

    public boolean hasWinningLine() {
        for(int i = 0; i < provider.getLineCount(); i++)
            if (isWinningLine(i))
                return true;

        return false;
    }


    public Line getWinningLine() {
        for(int i = 0; i < provider.getLineCount(); i++)
            if (isWinningLine(i))
                return provider.getLine(i);

        throw new NoWinningLineAvailable();
    }

    private boolean isWinningLine(int index) {
        Line line = provider.getLine(index);
        return evaluator.isWinningLine(line);
    }
}
