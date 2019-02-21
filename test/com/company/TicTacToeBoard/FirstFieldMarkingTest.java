package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.MarkBits;

import static org.junit.jupiter.api.Assertions.*;

public class FirstFieldMarkingTest {

    TicTacToeBoard sut = new TicTacToeBoard();
    Field field = new Field(0, 1);

    @Test
    void FreshInstance_Row0Column1ShouldBeEmpty() {
        boolean actual = sut.isEmpty(field);
        assertTrue(actual);
    }

    @Test
    void FreshInstance_Row0Column1ShouldNotBeO() {
        boolean actual = sut.isO(field);
        assertFalse(actual);
    }

    @Test
    void FreshInstance_Row0Column1ShouldNotBeX() {
        boolean actual = sut.isX(field);
        assertFalse(actual);
    }

    @Test
    void IfRow0Column1WasMarkedWithX_ItShouldBeX() {
        sut.markX(field);

        boolean actual = sut.isX(field);
        assertTrue(actual);
    }

    @Test
    void IfRow0Column1WasMarkedWithX_ItShouldNotBeEmpty() {
        sut.markX(field);

        boolean actual = sut.isEmpty(field);
        assertFalse(actual);
    }

    @Test
    void IfRow0Column1WasMarkedWithO_ItShouldBeO() {
        sut.markO(field);

        boolean actual = sut.isO(field);
        assertTrue(actual);
    }

    @Test
    void IfRow0Column1WasMarkedWithO_ItShouldNotBeEmpty() {
        sut.markO(field);

        boolean actual = sut.isEmpty(field);
        assertFalse(actual);
    }


}
