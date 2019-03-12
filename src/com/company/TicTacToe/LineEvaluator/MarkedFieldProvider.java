package com.company.TicTacToe.LineEvaluator;

import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Field.Field;

public interface MarkedFieldProvider {

    Mark getMarkAt(Field f);
    boolean isMarked(Field f);

    class FieldIsNotMarkedException extends RuntimeException {}
}
