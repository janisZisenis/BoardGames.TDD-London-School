package com.company.TicTacToe.FieldExistsValidator;

import com.company.TicTacToe.Field;

import java.util.Arrays;

public class FieldExistsProviderStub implements FieldExistsProvider {
    private Field[] existing = {};

    public void setExistingFields(Field[] existing) {
        this.existing = existing;
    }

    public boolean exists(Field field) {
        return Arrays.asList(existing).contains(field);
    }
}
