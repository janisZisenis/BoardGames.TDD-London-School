package com.company.TicTacToe.Board.HashingBoard;

import com.company.TicTacToe.Field.Field;
import com.company.TicTacToe.Board.Mark;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarkedFieldCountTest {

    private HashingBoard sut = new HashingBoard();

    @Test
    void FreshInstance_ShouldAMarkedFieldCountOf0() {
        assertHasMarkedFieldCount(0);
    }

    @Test
    void IfOneFieldGetsMarked_ShouldAMarkedFieldCountOf1() {
        Field field = new Field(0, 0);

        sut.mark(field, Mark.John);

        assertHasMarkedFieldCount(1);
    }

    @Test
    void IfTwoFieldsGetMarked_ShouldAMarkedFieldCountOf2() {
        Field first = new Field(0, 0);
        Field second = new Field(0, 1);

        sut.mark(first, Mark.John);
        sut.mark(second, Mark.Haley);

        assertHasMarkedFieldCount(2);
    }

    private void assertHasMarkedFieldCount(int expected) {
        int actual = sut.getMarkedFieldCount();
        assertEquals(expected, actual);
    }

}
