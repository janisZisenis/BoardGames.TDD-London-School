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
    void IfRowIsBiggerThan2_FieldShouldNotExist() {
        field = new Field(3, 0);
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

    @Test
    void IfColumnIsBiggerThan3_FieldShouldNotExist() {
        field = new Field(0, 3);
        sut = new TicTacToeBoard();

        actual = sut.exists(field);

        assertFalse(actual);
    }

    @Test
    void IfColumnIsBiggerThan4_FieldShouldNotExist() {
        field = new Field(0, 4);
        sut = new TicTacToeBoard();

        actual = sut.exists(field);

        assertFalse(actual);
    }

    @Test
    void IfColumnIsBiggerThan5_FieldShouldNotExist() {
        field = new Field(0, 5);
        sut = new TicTacToeBoard();

        actual = sut.exists(field);

        assertFalse(actual);
    }

}
