package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;

import java.util.HashMap;

public class TicTacToeBoard {

    private HashMap<Field, Mark> markedFields = new HashMap<Field, Mark>();

    public boolean exists(Field field) {
        int row = field.getRow();
        int col = field.getColumn();

        if(isOutOfBounds(row) || isOutOfBounds(col))
            return false;

        return true;
    }

    public boolean isEmpty(Field f) {
        throwIfFieldDoesNotExist(f);
        return fieldWasNotMarked(f);
    }

    public void mark(Field f, Mark m) {
        throwIfFieldDoesNotExist(f);
        store(f, m);
    }

    public Mark getMarkAt(Field field) {
        if(field.getRow () < 0 || field.getRow() > 2 || field.getColumn() > 2 || field.getColumn() < 0)
            throw new FieldDoesNotExist();

        if(markedFields.keySet().contains(field))
            return markedFields.get(field);

        throw new FieldIsEmpty();
    }


    private boolean isOutOfBounds(int row) {
        return row < 0 || row > 2;
    }

    private boolean fieldWasNotMarked(Field f) {
        return !markedFields.keySet().contains(f);
    }

    private void throwIfFieldDoesNotExist(Field f) {
        if(!exists(f))
            throw new FieldDoesNotExist();
    }


    private void store(Field f, Mark m) {
        markedFields.put(f, m);
    }

    public class FieldDoesNotExist extends RuntimeException {}

    public class FieldIsEmpty extends RuntimeException {}
}
