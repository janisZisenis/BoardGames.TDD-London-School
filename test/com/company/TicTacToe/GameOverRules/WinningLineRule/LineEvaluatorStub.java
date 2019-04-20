package com.company.TicTacToe.GameOverRules.WinningLineRule;

import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Line;

import java.util.Arrays;
import java.util.HashMap;

public class LineEvaluatorStub implements LineEvaluator {
    private Line[] winning = {};
    private HashMap<Line, Mark> winners = new HashMap<>();

    public void setWinningLines(Line[] winning) {
        this.winning = winning;
    }
    public void setWinnerForLine(Mark winner, Line line) {
        winners.put(line, winner);
    }

    public boolean isWinningLine(Line line) {
        return Arrays.asList(winning).contains(line);
    }
    public Mark getWinner(Line line) { return winners.get(line); }
}
