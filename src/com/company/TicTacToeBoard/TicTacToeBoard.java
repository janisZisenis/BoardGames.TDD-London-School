package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;

public class TicTacToeBoard {

    Mark first = null;
    Field firstField = null;

    Mark second = null;
    Field secondField = null;

    public boolean exists(Field field) {
        if(isOutOfBounds(field.getRow()) || isOutOfBounds(field.getColumn()))
            return false;

        return true;
    }

    private boolean isOutOfBounds(int row) {
        return row < 0 || row > 2;
    }

    public boolean isEmpty(Field field) {
        if(firstField != null)
            if(field.equals(firstField))
                return false;
        if(secondField != null)
            if(field.equals(secondField))
                return false;
        return true;
    }

    public void mark(Field f, Mark m) {
        if(first == null) {
            this.first = m;
            this.firstField = f;
        }
        else if(second == null) {
            secondField = f;
            second = m;
        }
    }

    public Mark getMarkAt(Field field) {
        if(first != null && field.equals(firstField))
            return first;

        if(second != null && field.equals(secondField))
            return second;


        return null;
    }

}
