package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.MarkBits;

import static org.junit.jupiter.api.Assertions.*;

public class FirstFieldMarkingTest {

    TicTacToeBoard sut = new TicTacToeBoard();
    Field field = new Field(1, 2);

    @Test
    void FreshInstance_FieldShouldBeEmpty() {
        sut = new TicTacToeBoard();
        field = new Field(0, 0);

        boolean actual = sut.isEmpty(field);
        assertTrue(actual);
    }

    @Test
    void FieldIsMarked_ItShouldNotBeEmpty() {
        sut.mark(field, Mark.X);

        boolean actual = sut.isEmpty(field);
        assertFalse(actual);
    }

    @Test
    void FieldGetsMarkedWithX_XShouldBeStoredAtField() {
        sut.mark(field, Mark.X);

        Mark actual = sut.getMarkAt(field);
        Mark expected = Mark.X;
        assertEquals(expected, actual);
    }

    @Test
    void FieldGetsMarkedWithO_OShouldBeStoredAtField() {
        sut.mark(field, Mark.O);

        Mark actual = sut.getMarkAt(field);
        Mark expected = Mark.O;
        assertEquals(expected, actual);
    }

}
