package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;

import java.util.LinkedList;

public class TicTacToeBoard {

    LinkedList<Field> fields = new LinkedList<Field>();

    public boolean exists(Field field) {
        if(isOutOfBounds(field.getRow()) || isOutOfBounds(field.getColumn()))
            return false;

        return true;
    }

    private boolean isOutOfBounds(int row) {
        return row < 0 || row > 2;
    }

    public boolean isEmpty(Field f) {
        for(int i = 0; fields.size() >= i + 1; i++)
            if (fields.get(i).equals(f))
                return false;

        return true;
    }

    public void mark(Field f, Mark m) {
        fields.add(f);
    }

}
