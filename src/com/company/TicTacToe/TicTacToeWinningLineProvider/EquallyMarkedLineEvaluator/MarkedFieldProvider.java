package com.company.TicTacToe.TicTacToeWinningLineProvider.EquallyMarkedLineEvaluator;

import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Board.Field.Field;

public interface MarkedFieldProvider {

    Mark getMarkAt(Field f);
    boolean isMarked(Field f);

    class FieldIsNotMarkedException extends RuntimeException {}
}
