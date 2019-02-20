package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeBoardTest {

    @Test
    void IfRowAndColumnExists_FieldShouldExist() {
        Field field = new Field(1, 1);
        TicTacToeBoard sut = new TicTacToeBoard();

        boolean actual = sut.exists(field);

        assertTrue(actual);
    }

    @Test
    void IfRowIsMinus1_FieldShouldNotExist() {
        Field field = new Field(-1, 0);
        TicTacToeBoard sut = new TicTacToeBoard();

        boolean actual = sut.exists(field);

        assertFalse(actual);
    }

    @Test
    void IfRowIsMinus2_FieldShouldNotExist() {
        Field field = new Field(-2, 0);
        TicTacToeBoard sut = new TicTacToeBoard();

        boolean actual = sut.exists(field);

        assertFalse(actual);
    }

    @Test
    void IfRowIsMinus3_FieldShouldNotExist() {
        Field field = new Field(-3, 0);
        TicTacToeBoard sut = new TicTacToeBoard();

        boolean actual = sut.exists(field);

        assertFalse(actual);
    }

}
