package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.MarkBits;

import static org.junit.jupiter.api.Assertions.*;

public class FirstFieldMarkingTest {

    TicTacToeBoard sut = new TicTacToeBoard();
    Field field;

    @Test
    void FreshInstance_Row0Column0ShouldBeEmpty() {
        sut = new TicTacToeBoard();
        field = new Field(0, 0);

        boolean actual = sut.isEmpty(field);
        assertTrue(actual);
    }

    @Test
    void Row0Column0Marked_ItShouldNotBeEmpty() {
        sut = new TicTacToeBoard();
        field = new Field(0, 0);

        sut.mark(field, Mark.X);

        boolean actual = sut.isEmpty(field);
        assertFalse(actual);
    }

    @Test
    void Row0Column0MarkedWithX_XShouldBeStoredAtRow0Column0() {
        sut = new TicTacToeBoard();
        field = new Field(0, 0);

        sut.mark(field, Mark.X);

        Mark actual = sut.getMarkAt(field);
        Mark expected = Mark.X;
        assertEquals(expected, actual);
    }

    @Test
    void Row0Column0MarkedWithO_OShouldBeStoredAtRow0Column0() {
        sut = new TicTacToeBoard();
        field = new Field(0, 0);

        sut.mark(field, Mark.O);

        Mark actual = sut.getMarkAt(field);
        Mark expected = Mark.O;
        assertEquals(expected, actual);
    }

}
