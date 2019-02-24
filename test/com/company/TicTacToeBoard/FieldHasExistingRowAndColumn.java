package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidator.Field;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class FieldHasExistingRowAndColumn {

    Field field = new Field(1, 1);
    TicTacToeBoard sut = new TicTacToeBoard();

    @Test
    void IfRowAndColumnExists_FieldShouldExist() {
        boolean actual = sut.exists(field);

        assertTrue(actual);
    }

    @Test
    void FreshInstance_getMarkAt_ShouldThrowException() {
        Executable act = () -> sut.getMarkAt(field);

        assertThrows(TicTacToeBoard.FieldIsEmpty.class, act);
    }
}
