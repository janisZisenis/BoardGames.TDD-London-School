package com.company.TicTacToe.InputValidating.FieldIsEmptyRule;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.ValidatingInputGenerator.InputRule;
import com.company.TicTacToe.Field.Field;

public class FieldIsEmptyRule implements InputRule {
    private final FieldIsEmptyProvider provider;

    public FieldIsEmptyRule(FieldIsEmptyProvider provider) {
        this.provider = provider;
    }

    public boolean isValid(Input input) {
        Field f = makeField(input);
        return provider.isEmpty(f);
    }

    private Field makeField(Input input) {
        int row = input.getRow();
        int col = input.getColumn();

        return new Field (row, col);
    }
}
