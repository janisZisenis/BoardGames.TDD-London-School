package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondFieldMarkingTest {

    TicTacToeBoard sut = new TicTacToeBoard();
    Field first;
    Field second;

    @Test
    void _0_0_Marked_1_1ShouldBeEmpty() {
        sut = new TicTacToeBoard();
        first = new Field(0, 0);
        second = new Field(1, 1);

        sut.mark(first, Mark.X);

        boolean actual = sut.isEmpty(second);
        assertTrue(actual);
    }

    @Test
    void _1_1Marked_0_0ShouldBeEmpty() {
        sut = new TicTacToeBoard();
        first = new Field(1, 1);
        second = new Field(0, 0);

        sut.mark(first, Mark.X);

        boolean actual = sut.isEmpty(second);
        assertTrue(actual);
    }

    @Test
    void _1_1MarkedAfter_0_0WasMarked_1_1ShouldNotBeEmpty() {
        sut = new TicTacToeBoard();
        first = new Field(0, 0);
        second = new Field(1, 1);
        sut.mark(first, Mark.X);

        sut.mark(second, Mark.O);

        boolean actual = sut.isEmpty(second);
        assertFalse(actual);
    }

    @Test
    void _1_1MarkedAfter_0_0WasMarked_2_2ShouldBeEmpty() {
        sut = new TicTacToeBoard();
        first = new Field(0, 0);
        second = new Field(1, 1);
        Field anotherField = new Field(2, 2);
        sut.mark(first, Mark.X);

        sut.mark(second, Mark.O);

        boolean actual = sut.isEmpty(anotherField);
        assertTrue(actual);
    }

    @Test
    void _1_1MarkedWithOAfter_0_0MarkedWithX_XShouldBeStoredAt_0_0() {
        sut = new TicTacToeBoard();
        first = new Field(0, 0);
        second = new Field(1, 1);
        sut.mark(first, Mark.X);

        sut.mark(second, Mark.O);

        Mark actual = sut.getMarkAt(first);
        Mark expected = Mark.X;
        assertEquals(expected, actual);
    }

    @Test
    void _1_1MarkedWithOAfter_2_2MarkedWithX_XShouldBeStoredAt_2_2() {
        sut = new TicTacToeBoard();
        first = new Field(2, 2);
        second = new Field(1, 1);
        sut.mark(first, Mark.X);

        sut.mark(second, Mark.O);

        Mark actual = sut.getMarkAt(first);
        Mark expected = Mark.X;
        assertEquals(expected, actual);
    }

    @Test
    void _1_1MarkedWithOAfter_0_0MarkedX_OShouldBeStoredAt_1_1() {
        sut = new TicTacToeBoard();
        first = new Field(0, 0);
        second = new Field(1, 1);
        sut.mark(first, Mark.X);

        sut.mark(second, Mark.O);

        Mark actual = sut.getMarkAt(second);
        Mark expected = Mark.O;
        assertEquals(expected, actual);
    }

    @Test
    void _1_1MarkedWithOAfter_0_0WasMarkedWithX_OShouldBeStoredAt_2_2() {
        sut = new TicTacToeBoard();
        first = new Field(0, 0);
        second = new Field(2, 2);
        sut.mark(first, Mark.X);

        sut.mark(second, Mark.O);

        Mark actual = sut.getMarkAt(second);
        Mark expected = Mark.O;
        assertEquals(expected, actual);
    }

}
