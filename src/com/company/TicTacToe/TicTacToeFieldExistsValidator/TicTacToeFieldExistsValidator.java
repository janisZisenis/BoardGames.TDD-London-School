package com.company.TicTacToe.TicTacToeFieldExistsValidator;

import com.company.Core.InputGeneration.Input;
import com.company.Core.InputGeneration.InputValidator;

public class TicTacToeFieldExistsValidator implements InputValidator {

    int lower = 0;
    int upper = 2;

    public boolean isValid(Input input) {
        int row = input.getRow();
        int col = input.getColumn();

        return isOutOfBounds(row) && isOutOfBounds(col);
    }

    private boolean isOutOfBounds(int i) {
        return i >= lower && i <= upper;
    }

}
