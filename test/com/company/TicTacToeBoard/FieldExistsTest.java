package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FieldExistsTest {

    Field field;
    TicTacToeBoard sut = new TicTacToeBoard();

    boolean actual;

    @Test
    void IfRowAndColumnExists_FieldShouldExist() {
        makeFieldExists();

        actual = sut.exists(field);

        assertTrue(actual);
    }

    @Test
    void IfRowIsNegative_FieldShouldNotExist() {
        makeFieldHasNegativeRow();

        actual = sut.exists(field);

        assertFalse(actual);
    }

    @Test
    void IfRowIsBiggerThan2_FieldShouldNotExist() {
        makeFieldHasRowBiggerThan2();

        actual = sut.exists(field);

        assertFalse(actual);
    }

    @Test
    void IfColumnIsNegative_FieldShouldNotExist() {
        makeFieldHasNegativeColumn();

        actual = sut.exists(field);

        assertFalse(actual);
    }

    @Test
    void IfColumnIsBiggerThan2_FieldShouldNotExist() {
        makeFieldHasColumnBiggerThan2();

        actual = sut.exists(field);

        assertFalse(actual);
    }


    private void makeFieldExists() {
        field = new Field(1, 1);
    }

    private void makeFieldHasNegativeRow() {
        field = new Field(-1, 0);
    }

    private void makeFieldHasRowBiggerThan2() {
        field = new Field(3, 0);
    }

    private void makeFieldHasNegativeColumn() {
        field = new Field(0, -1);
    }

    private void makeFieldHasColumnBiggerThan2() {
        field = new Field(0, 3);
    }

}
