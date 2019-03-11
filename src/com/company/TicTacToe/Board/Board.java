package com.company.TicTacToe.Board;

import com.company.TicTacToe.NumberOfMovesReferee.MarkedFieldCountProvider;
import com.company.TicTacToe.Field.Field;
import com.company.TicTacToe.InputValidating.FieldIsEmptyValidator.FieldIsEmptyProvider;
import com.company.TicTacToe.Player.MarkFieldService;

public interface Board extends MarkFieldService, FieldIsEmptyProvider, MarkedFieldCountProvider {

    boolean isEmpty(Field f);
    void mark(Field f, Mark m);
    Mark getMarkAt(Field f);
    int getMarkedFieldCount();

    class FieldIsNotMarked extends RuntimeException {}

}
