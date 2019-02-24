package com.company.TicTacToe.IsOnBoardValidator;

import com.company.TicTacToe.Field;

public class FieldExistsProviderStub implements FieldExistsProvider {
    private boolean fieldExists = false;

    public void setFieldExists(boolean b) {
        fieldExwists = b;
    }

    public boolean exists(Field f) {
        return fieldExists;
    }
}
