package com.company.TicTacToe.Board;

import com.company.TicTacToe.GameOverRules.NumberOfMovesRule.MarkedFieldCountProvider;
import com.company.TicTacToe.Board.Field.Field;
import com.company.TicTacToe.InputRules.FieldIsEmptyRule.FieldIsEmptyProvider;
import com.company.TicTacToe.GameOverRules.WinningLineRule.EquallyMarkedLineEvaluator.MarkedFieldProvider;
import com.company.TicTacToe.TicTacToePlayer.MarkFieldService;

public interface Board extends MarkFieldService, FieldIsEmptyProvider, MarkedFieldCountProvider, MarkedFieldProvider {

    boolean isEmpty(Field f);
    boolean isMarked(Field f);

    void mark(Field f, Mark m);
    Mark getMarkAt(Field f);
    int getMarkedFieldCount();

    class FieldIsNotMarked extends RuntimeException {}

}
