package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;

import java.util.LinkedList;

public class TicTacToeBoard {

    LinkedList<Field> fields = new LinkedList<Field>();

    private Field firstField = null;
    private Field secondField = null;
    private Field thirdField = null;

    public boolean exists(Field field) {
        if(isOutOfBounds(field.getRow()) || isOutOfBounds(field.getColumn()))
            return false;

        return true;
    }

    private boolean isOutOfBounds(int row) {
        return row < 0 || row > 2;
    }

    public boolean isEmpty(Field f) {
        if(firstField != null)
            if(firstField.equals(f))
                return false;
        if(secondField != null)
            if(secondField.equals(f))
                return false;
        if(thirdField != null)
            if(thirdField.equals(f))
                return false;
        return true;
    }

    public void mark(Field f, Mark m) {
        if(firstField == null) {
            firstField = f;
            fields.add(f);
        }
        else if(secondField == null) {
            secondField = f;
            fields.add(f);
        }
        else{
            thirdField = f;
            fields.add(f);
        }
    }

}
