package com.company.TicTacToe.GameOver.GameHasWinnerReferee;

import java.util.Arrays;

public class LineEvaluatorStub implements LineEvaluator {
    private Line[] winning = {};

    public void setWinningLines(Line[] winning) {
        this.winning = winning;
    }

    public boolean isWinningLine(Line line) {
        return Arrays.asList(winning).contains(line);
    }
}
