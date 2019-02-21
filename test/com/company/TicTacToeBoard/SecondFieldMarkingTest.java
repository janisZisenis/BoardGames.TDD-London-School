package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SecondFieldMarkingTest {

    TicTacToeBoard sut = new TicTacToeBoard();
    Field first;
    Field second;

    /////// TESTS ZU KOMPLEX --> LIEBER ENUM, ABER OHNE EMPTY NUR X,O!!!!!!!

    @Test
    void IfRow0Colum1WasMarkedWithX_Row1Column2ShouldBeEmpty() {
        first = new Field(0, 1);
        second = new Field(1, 2);

        sut.markX(first);

        boolean actual = sut.isEmpty(second);
        assertTrue(actual);
    }

    @Test
    void IfRow0Colum0WasMarkedWithX_Row1Column2ShouldBeNotBeX() {
        first = new Field(0, 1);
        second = new Field(1, 2);

        sut.markX(first);

        boolean actual = sut.isX(second);
        assertFalse(actual);
    }

    @Test
    void IfRow0Colum0WasMarkedWithO_Row1Column2ShouldBeEmpty() {
        first = new Field(0, 1);
        second = new Field(1, 2);

        sut.markO(first);

        boolean actual = sut.isEmpty(second);
        assertTrue(actual);
    }

    @Test
    void IfRow0Colum0WasMarkedWithX_Row1Column2ShouldBeNotBeO() {
        first = new Field(0, 1);
        second = new Field(1, 2);

        sut.markO(first);

        boolean actual = sut.isO(second);
        assertFalse(actual);
    }

    @Test
    void IfRow1Column0WasMarkedWithX_Row0Column0ShouldBeEmpty() {
        first = new Field(1, 0);
        second = new Field(0, 0);

        sut.markX(first);

        boolean actual = sut.isEmpty(second);
        assertTrue(actual);
    }

    @Test
    void IfRow1Column0WasMarkedWithX_Row0Column0ShouldNotBeX() {
        first = new Field(1, 0);
        second = new Field(0, 0);

        sut.markX(first);

        boolean actual = sut.isX(second);
        assertFalse(actual);
    }

    @Test
    void IfRow1Column0WasMarkedWithO_Row0Column0ShouldBeEmpty() {
        first = new Field(1, 0);
        second = new Field(0, 0);

        sut.markO(first);

        boolean actual = sut.isEmpty(second);
        assertTrue(actual);
    }

    @Test
    void IfRow1Column0WasMarkedWithO_Row0Column0ShouldNotBeO() {
        first = new Field(1, 0);
        second = new Field(0, 0);

        sut.markO(first);

        boolean actual = sut.isO(second);
        assertFalse(actual);
    }

}
