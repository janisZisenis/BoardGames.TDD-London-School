package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;

public class TicTacToeBoard {

    private Mark first = null;
    private Field firstField = null;

    public boolean exists(Field field) {
        if(isOutOfBounds(field.getRow()) || isOutOfBounds(field.getColumn()))
            return false;

        return true;
    }

    private boolean isOutOfBounds(int row) {
        return row < 0 || row > 2;
    }

    public boolean isEmpty(Field f) {
        return firstField == null;
    }

    public void mark(Field f, Mark m) {
        firstField = f;
        first = m;
    }

    public Mark getMarkAt(Field f) {
        return first;
    }

}
