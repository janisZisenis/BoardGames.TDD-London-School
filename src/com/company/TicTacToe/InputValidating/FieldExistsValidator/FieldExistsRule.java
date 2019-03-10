package com.company.TicTacToe.InputValidating.FieldExistsValidator;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputRule;
import com.company.TicTacToe.Constants.BoardBoundaries;

public class FieldExistsRule implements InputRule {

    private final int rowColumnCount = BoardBoundaries.rowColumnCount;

    public boolean validates(Input input) {
        int row = input.getRow();
        int col = input.getColumn();

        return isOutOfBounds(row) && isOutOfBounds(col);
    }

    private boolean isOutOfBounds(int i) {
        return i >= 0 && i < rowColumnCount;
    }

}
