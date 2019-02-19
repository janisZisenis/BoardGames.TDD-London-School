package com.company.IsOnBoardValidatorImp;

import com.company.UserInput;

public class IsOnBoardValidatorImp {

    private final Board board;

    public IsOnBoardValidatorImp(Board board) {
        this.board = board;
    }

    public boolean isOnBoard(UserInput input) {
        int row = input.getRow();
        int column = input.getColumn();

        Field f = new Field(row, column);

        return board.exists(f);
    }
}
