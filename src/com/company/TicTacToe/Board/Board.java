package com.company.TicTacToe.Board;

import com.company.TicTacToe.GameOverRule.TieGameRule.MarkedFieldCountProvider;
import com.company.TicTacToe.Field.Field;
import com.company.TicTacToe.InputValidating.FieldIsEmptyRule.FieldIsEmptyProvider;
import com.company.TicTacToe.LineEvaluator.MarkedFieldProvider;
import com.company.TicTacToe.Player.MarkFieldService;

public interface Board extends MarkFieldService, FieldIsEmptyProvider, MarkedFieldCountProvider, MarkedFieldProvider {

    boolean isEmpty(Field f);
    boolean isMarked(Field f);

    void mark(Field f, Mark m);
    Mark getMarkAt(Field f);
    int getMarkedFieldCount();

    class FieldIsNotMarked extends RuntimeException {}

}
