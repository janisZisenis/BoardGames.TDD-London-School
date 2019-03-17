package com.company.TicTacToe.InputRules.FieldIsEmptyRule;

import com.company.TicTacToe.Board.Field.Field;

public interface FieldIsEmptyProvider {
    boolean isEmpty(Field field);
}
