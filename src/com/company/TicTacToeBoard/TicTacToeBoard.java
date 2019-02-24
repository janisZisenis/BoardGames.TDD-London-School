package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;

import java.util.LinkedList;

public class TicTacToeBoard {

    private LinkedList<Field> fields = new LinkedList<Field>();
    private Mark first;
    private Mark second;

    public boolean exists(Field field) {
        if(isOutOfBounds(field.getRow()) || isOutOfBounds(field.getColumn()))
            return false;

        return true;
    }

    private boolean isOutOfBounds(int row) {
        return row < 0 || row > 2;
    }

    public boolean isEmpty(Field f) {
        throwIfFieldDoesNotExist(f);
        return fieldWasMarked(f);
    }

    private boolean fieldWasMarked(Field f) {
        for(int i = 0; fields.size() >= i + 1; i++)
            if (fields.get(i).equals(f))
                return false;

        return true;
    }

    private void throwIfFieldDoesNotExist(Field f) {
        if(!exists(f))
            throw new FieldDoesNotExist();
    }

    public void mark(Field f, Mark m) {
        throwIfFieldDoesNotExist(f);

        fields.add(f);

        if(first == null)
            first = m;
        second = m;
    }

    public Mark getMarkAt(Field field) {
        if(first != null)
            if(field.equals(fields.get(0)))
                return first;

        return second;
    }

    public class FieldDoesNotExist extends RuntimeException {}
}
