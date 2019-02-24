package com.company.TicTacToe.IsOnBoardValidator;

import com.company.TicTacToe.Field;

public interface FieldExistsProvider {
    boolean exists(Field f);
}
