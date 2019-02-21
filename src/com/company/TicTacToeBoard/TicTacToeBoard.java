package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;

public class TicTacToeBoard {

    private Field xField = null;
    private Field oField = null;

    private boolean markedO = false;

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
            if(field.getRow() != 0 && field.getColumn() != 0)
                return true;
        if(oField != null)
            if(field.getRow() != 0 && field.getColumn() != 0)
                return true;

        return xField == null && !markedO;
    }

    public void markX(Field field) {
        xField = field;
    }

    public boolean isX(Field field) {
        if (xField != null)
            if(field.getRow() != 0 && field.getColumn() != 0)
                return false;

        return xField != null;
    }

    public boolean isO(Field field) {
        if (oField != null)
            if(field.getRow() != 0 && field.getColumn() != 0)
                return false;

        return markedO;
    }

    public void markO(Field field) {
        markedO = true;
        oField = field;
    }
}
