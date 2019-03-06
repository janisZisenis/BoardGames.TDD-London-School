package com.company.TicTacToe.ObservableBoard;

import com.company.TicTacToe.Board;
import com.company.TicTacToe.Field.Field;
import com.company.TicTacToe.Mark;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardForwardingTest {

    @Test
    void IfFieldIsEmptyOnTheBoard_ItShouldBeEmptyEither() {
        BoardStub board = new BoardStub();
        Field[] fields = { new Field(0, 0) };
        board.setEmptyFields(fields);
        ObservableBoard sut = new ObservableBoard(board);

        boolean actual = sut.isEmpty(fields[0]);

        assertTrue(actual);
    }

    @Test
    void IfFieldIsNotEmptyOnTheBoard_ItShouldBeNotEmptyEither() {
        BoardStub board = new BoardStub();
        Field[] fields = { new Field(0, 0) };
        ObservableBoard sut = new ObservableBoard(board);

        boolean actual = sut.isEmpty(fields[0]);

        assertFalse(actual);
    }

    @Test
    void IfBoardHas0MarkedField_ItShouldHave0MarkedFieldsEither() {
        BoardStub board = new BoardStub();
        board.setMarkedFieldCount(0);
        ObservableBoard sut = new ObservableBoard(board);

        int actual = sut.getMarkedFieldCount();

        int expected = 0;
        assertEquals(expected, actual);
    }

    @Test
    void IfBoardHas1MarkedField_ItShouldHave1MarkedFieldsEither() {
        BoardStub board = new BoardStub();
        board.setMarkedFieldCount(1);
        ObservableBoard sut = new ObservableBoard(board);

        int actual = sut.getMarkedFieldCount();

        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    void IfAFieldGetsMarkedWithJohn_ItShouldMarkTheFieldWithJohnOnTheBoard() {
        BoardMock board = new BoardMock();
        Field f = new Field(0, 1);
        Mark m = Mark.John;
        board.expectGetsMarkedWith(f, m);
        ObservableBoard sut = new ObservableBoard(board);

        sut.mark(f, m);

        board.verifyAll();
    }

    @Test
    void IfAFieldGetsMarkedWithHaley_ItShouldMarkTheFieldWithHaleyOnTheBoard() {
        BoardMock board = new BoardMock();
        Field f = new Field(0, 2);
        Mark m = Mark.Haley;
        board.expectGetsMarkedWith(f, m);
        ObservableBoard sut = new ObservableBoard(board);

        sut.mark(f, m);

        board.verifyAll();
    }

    private class BoardMock implements Board {

        private boolean wasMarked = false;
        private Field expectedField;
        private Mark expectedMark;
        private Mark actualMark;
        private Field actualField;

        public void expectGetsMarkedWith(Field f, Mark m) {
            this.expectedField = f;
            this.expectedMark = m;
        }

        public boolean isEmpty(Field f) {
            return false;
        }

        public void mark(Field f, Mark m) {
            this.wasMarked = true;
            this.actualField = f;
            this.actualMark = m;
        }

        public Mark getMarkAt(Field f) {
            return null;
        }

        public int getMarkedFieldCount() {
            return 0;
        }

        public void verifyAll() {
            assertTrue(wasMarked);
            assertEquals(expectedField, actualField);
            assertEquals(expectedMark, actualMark);
        }

    }
}
