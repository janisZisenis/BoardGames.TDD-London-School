package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FieldMarkingTest {

    TicTacToeBoard sut = new TicTacToeBoard();
    Field first = new Field(0, 1);

    @Test
    void IfFieldGetsMarkedWithX_XShouldBeStoredAtField() {
        sut.mark(first, Mark.X);

        Mark actual = sut.getMarkAt(first);
        Mark expected = Mark.X;
        assertEquals(expected, actual);
    }

    @Test
    void IfFieldGetsMarkedWithO_OShouldBeStoredAtField() {
        sut.mark(first, Mark.O);

        Mark actual = sut.getMarkAt(first);
        Mark expected = Mark.O;
        assertEquals(expected, actual);
    }

    @Test
    void FirstFieldWasMarkedWithO_SecondFieldGetsMarkedWithX_OShouldBeStoredAtFirstField() {
        sut.mark(first, Mark.O);
        Field second = new Field(1, 2);

        sut.mark(second, Mark.X);

        Mark actual = sut.getMarkAt(first);
        Mark expected = Mark.O;
        assertEquals(expected, actual);
    }

    @Test
    void FirstFieldWasMarkedWithX_SecondFieldGetsMarkedWithO_OShouldBeStoredAtSecondField() {
        sut.mark(first, Mark.X);
        Field second = new Field(1, 2);

        sut.mark(second, Mark.O);

        Mark actual = sut.getMarkAt(second);
        Mark expected = Mark.O;
        assertEquals(expected, actual);
    }

}