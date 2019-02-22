package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SecondFieldMarkingTest {

    TicTacToeBoard sut = new TicTacToeBoard();
    Field first;
    Field second;


    @Test
    void Row0Column0Marked_Row1Column1ShouldBeEmpty() {
        sut = new TicTacToeBoard();
        first = new Field(0, 0);
        second = new Field(1, 1);

        sut.mark(first, Mark.X);

        boolean actual = sut.isEmpty(second);
        assertTrue(actual);
    }

    @Test
    void Row1Column1Marked_Row0Column0ShouldBeEmpty() {
        sut = new TicTacToeBoard();
        first = new Field(1, 1);
        second = new Field(0, 0);

        sut.mark(first, Mark.X);

        boolean actual = sut.isEmpty(second);
        assertTrue(actual);
    }



    @Test
    void IfRow1Column1GetsMarkedWithOAfterRow0Column0WasMarkedWithX_XShouldBeStoredAtRow0Column0() {
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
    void IfRow1Column1GetsMarkedWith2AfterRow2Column0WasMarkedWithX_XShouldBeStoredAtRow2Column2() {
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
    void IfRow1Column1GetsMarkedWithOAfterRow0Column0WasMarkedX_OShouldBeStoredAtRow1Column1() {
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
    void IfRow1Column1GetsMarkedWithOAfterRow0Column0WasMarkedX_OShouldBeStoredAtRow2Column2() {
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
