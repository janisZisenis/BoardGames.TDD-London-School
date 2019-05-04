package Domain.GameEvaluation.GameEvaluator;

import Domain.Data.Line.Line;
import Domain.Board.Mark;

import java.util.HashMap;

public class LineEvaluatorStub implements LineEvaluator {
    private HashMap<Line, Mark> winners = new HashMap<>();

    public void setWinnerForLine(Mark winner, Line line) {
        winners.put(line, winner);
    }

    public boolean isWinningLine(Line line) {
        return winners.keySet().contains(line);
    }

    public Mark getWinner(Line line) { return winners.get(line); }
}
