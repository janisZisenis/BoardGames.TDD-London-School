package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void FirstFieldWasMarkedWithX_SecondFieldGetsMarkedWithO_ThirdFieldGetsMarkedWithX_OShouldBeStoredAtSecondField() {
        sut.mark(first, Mark.X);
        Field second = new Field(1, 2);
        sut.mark(second, Mark.O);
        Field third = new Field(1, 1);

        sut.mark(third, Mark.X);

        Mark actual = sut.getMarkAt(second);
        Mark expected = Mark.O;
        assertEquals(expected, actual);
    }

    @Test
    void FirstFieldWasMarkedWithX_SecondFieldGetsMarkedWithO_ThirdFieldGetsMarkedWithX_XShouldBeStoredAtThirdField() {
        sut.mark(first, Mark.X);
        Field second = new Field(1, 2);
        sut.mark(second, Mark.O);
        Field third = new Field(1, 1);

        sut.mark(third, Mark.X);

        Mark actual = sut.getMarkAt(third);
        Mark expected = Mark.X;
        assertEquals(expected, actual);
    }

    @Test
    void FirstFieldWasMarkedWithO_SecondFieldGetsMarkedWithX_ThirdFieldGetsMarkedWithO_OShouldBeStoredAtThirdField() {
        sut.mark(first, Mark.O);
        Field second = new Field(1, 2);
        sut.mark(second, Mark.X);
        Field third = new Field(1, 1);

        sut.mark(third, Mark.O);

        Mark actual = sut.getMarkAt(third);
        Mark expected = Mark.O;
        assertEquals(expected, actual);
    }

    @Test
    void FreshInstance_mark_ShouldThrowException() {
        Field field = new Field(1, 2);

        Executable act = () -> sut.getMarkAt(field);

        assertThrows(TicTacToeBoard.FieldIsEmpty.class, act);
    }

}