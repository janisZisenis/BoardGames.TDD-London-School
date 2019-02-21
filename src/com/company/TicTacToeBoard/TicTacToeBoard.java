package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;

public class TicTacToeBoard {

    private Field xField = null;
    private Field oField = null;

    public boolean exists(Field field) {
        if(isOutOfBounds(field.getRow()) || isOutOfBounds(field.getColumn()))
            return false;

        return true;
    }

    private boolean isOutOfBounds(int row) {
        return row < 0 || row > 2;
    }

    public boolean isEmpty(Field field) {
        if(xField != null)
            if(!field.equals(xField))
                return true;
        if(oField != null)
            if(!field.equals(oField))
                return true;

        return xField == null && oField == null;
    }

    public void markX(Field field) {
        xField = field;
    }

    public boolean isX(Field field) {
        if(xField == null)
            return false;

        return field.equals(xField);
    }

    public boolean isO(Field field) {
        if(oField == null)
            return false;

        return field.equals(oField);
    }

    public void markO(Field field) {
        oField = field;
    }
}
