package com.company.IsOnBoardValidator;

import com.company.AlertingValidator.Validator;
import com.company.UserInput;

public class IsOnBoardValidator implements Validator {

    private final Board board;

    public IsOnBoardValidator(Board board) {
        this.board = board;
    }

    public boolean isValid(UserInput in) {
        Field f = makeField(in);
        return board.exists(f);
    }

    private Field makeField(UserInput in) {
        int row = in.getRow();
        int column = in.getColumn();

        return new Field(row, column);
    }
}
