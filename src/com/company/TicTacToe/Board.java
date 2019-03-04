package com.company.TicTacToe;

import com.company.TicTacToe.Field.Field;

public interface Board {

    boolean isEmpty(Field f);
    void mark(Field f, Mark m);
    Mark getMarkAt(Field f);
    int getMarkedFieldCount();

    class FieldIsEmpty extends RuntimeException {}
}
