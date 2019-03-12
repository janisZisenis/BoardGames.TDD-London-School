package com.company.TicTacToe.LineEvaluator;

import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Field.Field;

public class IsWinningLineEvaluator {

    private final MarkedFieldProvider provider;

    public IsWinningLineEvaluator(MarkedFieldProvider provider) {
        this.provider = provider;
    }

    public boolean isWinningLine(Line line) {
        return isFullyMarked(line) && isEquallyMarked(line);
    }

    private boolean isEquallyMarked(Line line) {
        Mark first = provider.getMarkAt(line.getFirst());
        Mark second = provider.getMarkAt(line.getSecond());
        Mark third = provider.getMarkAt(line.getThird());

        return first == second && second == third;
    }

    private boolean isFullyMarked(Line line) {
        Field first = line.getFirst();
        Field second = line.getSecond();
        Field third = line.getThird();

        return provider.isMarked(first) && provider.isMarked(second) && provider.isMarked(third);
    }
}
