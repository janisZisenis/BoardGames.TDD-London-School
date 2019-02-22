package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldIsEmptyTest {

    @Test
    void FreshInstance_FieldShouldBeEmpty() {
        TicTacToeBoard sut = new TicTacToeBoard();
        Field field = new Field(1, 2);

        boolean actual = sut.isEmpty(field);
        assertTrue(actual);
    }

    @Test
    void FieldIsMarked_ItShouldNotBeEmpty() {
        TicTacToeBoard sut = new TicTacToeBoard();
        Field field = new Field(1, 2);

        sut.mark(field, Mark.X);

        boolean actual = sut.isEmpty(field);
        assertFalse(actual);
    }

    @Test
    void FieldIsMarked_ASecondFieldShouldBeEmpty() {
        TicTacToeBoard sut = new TicTacToeBoard();
        Field first = new Field(1, 2);
        Field second = new Field(1, 3);

        sut.mark(first, Mark.X);

        boolean actual = sut.isEmpty(second);
        assertTrue(actual);
    }

    @Test
    void TwoFieldsAreMarked_FirstFieldShouldNotBeEmpty() {
        TicTacToeBoard sut = new TicTacToeBoard();
        Field first = new Field(1, 2);
        Field second = new Field(1, 3);

        sut.mark(first, Mark.X);
        sut.mark(second, Mark.X);

        boolean actual = sut.isEmpty(first);
        assertFalse(actual);
    }

    @Test
    void TwoFieldsAreMarked_SecondFieldShouldNotBeEmpty() {
        TicTacToeBoard sut = new TicTacToeBoard();
        Field first = new Field(1, 2);
        Field second = new Field(1, 3);

        sut.mark(first, Mark.X);
        sut.mark(second, Mark.X);

        boolean actual = sut.isEmpty(second);
        assertFalse(actual);
    }

    @Test
    void TwoFieldsAreMarked_ThirdFieldShouldBeEmpty() {
        TicTacToeBoard sut = new TicTacToeBoard();
        Field first = new Field(1, 2);
        Field second = new Field(1, 3);
        Field third = new Field(2, 1);

        sut.mark(first, Mark.X);
        sut.mark(second, Mark.X);

        boolean actual = sut.isEmpty(third);
        assertTrue(actual);
    }

    @Test
    void ThreeFieldsAreMarked_ThirdFieldShouldNotBeEmpty() {
        TicTacToeBoard sut = new TicTacToeBoard();
        Field first = new Field(1, 2);
        Field second = new Field(1, 3);
        Field third = new Field(2, 1);
        sut.mark(first, Mark.X);
        sut.mark(second, Mark.X);
        sut.mark(third, Mark.X);

        boolean actual = sut.isEmpty(third);
        assertFalse(actual);
    }

    @Test
    void ThreeFieldsAreMarked_FourthFieldShouldBeEmpty() {
        TicTacToeBoard sut = new TicTacToeBoard();
        Field first = new Field(1, 2);
        Field second = new Field(1, 3);
        Field third = new Field(2, 1);
        Field fourth = new Field(2, 2);
        sut.mark(first, Mark.X);
        sut.mark(second, Mark.X);
        sut.mark(third, Mark.X);

        boolean actual = sut.isEmpty(fourth);
        assertTrue(actual);
    }


}
