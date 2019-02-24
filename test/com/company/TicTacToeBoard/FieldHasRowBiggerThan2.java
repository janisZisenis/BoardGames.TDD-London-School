package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class FieldHasRowBiggerThan2 {

    TicTacToeBoard sut = new TicTacToeBoard();
    Field field = new Field(3, 0);

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

    @Test
    void FreshInstance_mark_ShouldThrowException() {
        Executable act = () -> sut.mark(field, Mark.John);

        assertThrows(TicTacToeBoard.FieldDoesNotExist.class, act);
    }

    @Test
    void FreshInstance_getMarkAt_ShouldThrowException() {
        Executable act = () -> sut.getMarkAt(field);

        assertThrows(TicTacToeBoard.FieldDoesNotExist.class, act);
    }
}
