package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;

public class TicTacToeBoard {

    Mark mark = Mark.Empty;

    public boolean exists(Field field) {
        if(isOutOfBounds(field.getRow()) || isOutOfBounds(field.getColumn()))
            return false;

        return true;
    }

    private boolean isOutOfBounds(int row) {
        return row < 0 || row > 2;
    }

    public Mark getMark(Field field) {
        return mark;
    }

    public void markField(Field field, Mark mark) {
        this.mark = mark;
    }

    public enum Mark {
        X, O, Empty
    }
}
