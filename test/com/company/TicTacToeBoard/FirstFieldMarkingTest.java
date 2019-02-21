package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.MarkBits;

import static org.junit.jupiter.api.Assertions.*;

public class FirstFieldMarkingTest {

    TicTacToeBoard sut = new TicTacToeBoard();
    Field field = new Field(0, 0);

    @Test
    void FreshInstance_Row0Column0ShouldBeEmpty() {
        boolean actual = sut.isEmpty(field);
        assertTrue(actual);
    }

    @Test
    void FreshInstance_Row0Column0ShouldNotBeO() {
        boolean actual = sut.isO(field);
        assertFalse(actual);
    }

    @Test
    void FreshInstance_Row0Column0ShouldNotBeX() {
        boolean actual = sut.isX(field);
        assertFalse(actual);
    }

    @Test
    void IfRow0Column0WasMarkedWithX_Row0Column0ShouldBeX() {
        sut.markX(field);

        boolean actual = sut.isX(field);
        assertTrue(actual);
    }

    @Test
    void IfRow0Column0WasMarkedWithX_Row0Column0ShouldNotBeEmpty() {
        sut.markX(field);

        boolean actual = sut.isEmpty(field);
        assertFalse(actual);
    }

    @Test
    void IfRow0Column0WasMarkedWithO_Row0Column0ShouldBeO() {
        sut.markO(field);

        boolean actual = sut.isO(field);
        assertTrue(actual);
    }

    @Test
    void IfRow0Column0WasMarkedWithO_Row0Column0ShouldNotBeEmpty() {
        sut.markO(field);

        boolean actual = sut.isEmpty(field);
        assertFalse(actual);
    }



    @Test
    void IfRow0Colum0WasMarkedWithX_Row1Column1ShouldBeEmpty() {
        Field anotherField = new Field(1, 1);

        sut.markX(field);

        boolean actual = sut.isEmpty(anotherField);
        assertTrue(actual);
    }

    @Test
    void IfRow0Colum0WasMarkedWithX_Row1Column1ShouldBeNotBeX() {
        Field anotherField = new Field(1, 1);

        sut.markX(field);

        boolean actual = sut.isX(anotherField);
        assertFalse(actual);
    }

    @Test
    void IfRow0Colum0WasMarkedWithO_Row1Column1ShouldBeEmpty() {
        Field anotherField = new Field(1, 1);

        sut.markO(field);

        boolean actual = sut.isEmpty(anotherField);
        assertTrue(actual);
    }

    @Test
    void IfRow0Colum0WasMarkedWithX_Row1Column1ShouldBeNotBeO() {
        Field anotherField = new Field(1, 1);

        sut.markO(field);

        boolean actual = sut.isO(anotherField);
        assertFalse(actual);
    }

}
