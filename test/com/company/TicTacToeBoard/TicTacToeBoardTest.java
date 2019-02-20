package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeBoardTest {

    Field field;
    TicTacToeBoard sut;

    boolean actual;

    @Test
    void IfRowAndColumnExists_FieldShouldExist() {
        field = new Field(1, 1);
        sut = new TicTacToeBoard();

        actual = sut.exists(field);

        assertTrue(actual);
    }

    @Test
    void IfRowIsNegative_FieldShouldNotExist() {
        field = new Field(-1, 0);
        sut = new TicTacToeBoard();

        actual = sut.exists(field);

        assertFalse(actual);
    }

    @Test
    void IfRowIs3_FieldShouldNotExist() {
        field = new Field(3, 0);
        sut = new TicTacToeBoard();

        actual = sut.exists(field);

        assertFalse(actual);
    }

    @Test
    void IfRowIs4_FieldShouldNotExist() {
        field = new Field(4, 0);
        sut = new TicTacToeBoard();

        actual = sut.exists(field);

        assertFalse(actual);
    }

    @Test
    void IfRowIs5_FieldShouldNotExist() {
        field = new Field(5, 0);
        sut = new TicTacToeBoard();

        actual = sut.exists(field);

        assertFalse(actual);
    }

    @Test
    void IfColumnIsNegative_FieldShouldNotExist() {
        field = new Field(0, -1);
        sut = new TicTacToeBoard();

        actual = sut.exists(field);

        assertFalse(actual);
    }

}
