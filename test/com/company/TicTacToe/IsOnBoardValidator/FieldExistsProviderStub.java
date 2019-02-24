package com.company.TicTacToe.IsOnBoardValidator;

public class FieldExistsProviderStub implements FieldExistsProvider {
    private boolean fieldExists = false;

    public void setFieldExists(boolean b) {
        fieldExwists = b;
    }

    public boolean exists(Field f) {
        return fieldExists;
    }
}
