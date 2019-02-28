package com.company.TicTacToe.FieldExistsValidator;

import com.company.Core.InputGeneration.InputValidator;
import com.company.Core.InputGeneration.Input;
import com.company.TicTacToe.Field;

public class FieldExistsValidator implements InputValidator {

    private final FieldExistsProvider provider;

    public FieldExistsValidator(FieldExistsProvider provider) {
        this.provider = provider;
    }

    public boolean isValid(Input in) {
        Field f = makeField(in);
        return provider.exists(f);
    }

    private Field makeField(Input in) {
        int row = in.getRow();
        int column = in.getColumn();

        return new Field(row, column);
    }
}
