package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;

import java.util.LinkedList;

public class TicTacToeBoard {

    private LinkedList<Field> fields = new LinkedList<Field>();
    private LinkedList<Mark> marks = new LinkedList<Mark>();

    public boolean exists(Field field) {
        int row = field.getRow();
        int col = field.getColumn();

        if(isOutOfBounds(row) || isOutOfBounds(col))
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
        store(f, m);
    }

    private void store(Field f, Mark m) {
        fields.add(f);
        marks.add(m);
    }

    public Mark getMarkAt(Field field) {
        for(int i = 0; i < marks.size(); i++)
            if (field.equals(fields.get(i)))
                return marks.get(i);

        throw new FieldIsEmpty();
    }

    public class FieldDoesNotExist extends RuntimeException {}

    public class FieldIsEmpty extends RuntimeException {}
}
