package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;

import java.util.LinkedList;

public class TicTacToeBoard {

    private LinkedList<Field> fields = new LinkedList<Field>();
    private Mark first;
    private Mark second;
    private Mark third;

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
        else if(second == null)
            second = m;

        third = m;
    }

    public Mark getMarkAt(Field field) {
        if(first != null)
            if(field.equals(fields.get(0)))
                return first;
        if(second != null)
            if(field.equals(fields.get(1)))
            return second;
        if(third != null)
            return third;

        throw new FieldIsEmpty();
    }

    public class FieldDoesNotExist extends RuntimeException {}

    public class FieldIsEmpty extends RuntimeException {}
}
