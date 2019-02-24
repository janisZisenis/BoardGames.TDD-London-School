package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FieldHasColumnBiggerThan2 {

    TicTacToeBoard sut = new TicTacToeBoard();
    Field field = new Field(0, 3);

    @Test
    void FreshInstance_FieldShouldNotExist() {
        boolean actual = sut.exists(field);

        assertFalse(actual);
    }

    @Test
    void FreshInstance_isEmpty_ShouldThrowException() {
        Executable act = () -> sut.isEmpty(field);

        assertThrows(TicTacToeBoard.FieldDoesNotExist.class, act);
    }


}
