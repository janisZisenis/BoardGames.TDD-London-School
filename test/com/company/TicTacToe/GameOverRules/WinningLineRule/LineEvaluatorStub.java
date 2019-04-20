package com.company.TicTacToe.GameOverRules.WinningLineRule;

import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Line;

import java.util.Arrays;

public class LineEvaluatorStub implements LineEvaluator {
    private Line[] winning = {};
    private Mark winner;

    public void setWinningLines(Line[] winning) {
        this.winning = winning;
    }
    public void setWinner(Mark winner) {
        this.winner = winner;
    }

    public boolean isWinningLine(Line line) {
        return Arrays.asList(winning).contains(line);
    }
    public Mark getWinner(Line line) { return this.winner; }
}
