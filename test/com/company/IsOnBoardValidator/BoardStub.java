package com.company.IsOnBoardValidator;

public class BoardStub implements Board {
    private boolean fieldIsOnBoard = false;

    public void setUserInputIsOnBoard(boolean b) {
        fieldIsOnBoard = b;
    }

    public boolean exists(Field f) {
        return fieldIsOnBoard;
    }
}
