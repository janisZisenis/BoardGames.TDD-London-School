package com.company.TicTacToe.GameOver.GameHasWinnerReferee;


import com.company.TicTacToe.Line;

public class GameHasWinnerReferee {
    private final LineProvider provider;
    private final LineEvaluator evaluator;

    public GameHasWinnerReferee(LineProvider provider, LineEvaluator evaluator) {
        this.provider = provider;
        this.evaluator = evaluator;
    }

    public boolean hasWinner() {

        for(int i = 0; i < provider.getLineCount(); i++) {
            Line line = provider.getLine(i);
            if (evaluator.isWinningLine(line)) {
                return true;
            }
        }

        return false;
    }
}
