package com.company.TicTacToe;

import com.company.TicTacToe.CountingReferee.MarkedFieldCountProvider;
import com.company.TicTacToe.Field.Field;
import com.company.TicTacToe.FieldIsEmptyValidator.FieldIsEmptyProvider;
import com.company.TicTacToe.Player.MarkFieldService;

public interface Board extends MarkFieldService, FieldIsEmptyProvider, MarkedFieldCountProvider {

    boolean isEmpty(Field f);
    void mark(Field f, Mark m);
    Mark getMarkAt(Field f);
    int getMarkedFieldCount();

    class FieldIsEmpty extends RuntimeException {}
}
