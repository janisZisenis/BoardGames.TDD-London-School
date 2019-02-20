package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;

public class TicTacToeBoard {

    public boolean exists(Field field) {
        if(field.getRow() < 0)
            return false;

        if(field.getColumn() < 0)
            return false;

        return true;
    }
}
