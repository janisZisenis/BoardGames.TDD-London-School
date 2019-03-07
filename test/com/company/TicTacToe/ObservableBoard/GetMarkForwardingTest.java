package com.company.TicTacToe.ObservableBoard;

import com.company.TicTacToe.Field.Field;
import com.company.TicTacToe.Mark;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GetMarkForwardingTest {

    private BoardStub board = new BoardStub();
    private ObservableBoard sut = new ObservableBoard(board);
    private Field field = new Field(0, 1);

    @Test
    void IfBoardHasHaleyOnField_ItShouldGetTheMarkHaley() {
        board.setMark(Mark.Haley);

        Mark actual = sut.getMarkAt(field);

        Mark expected = Mark.Haley;
        assertEquals(expected, actual);
    }

    @Test
    void IfBoardHasJohnOnField_ItShouldGetTheMarkJohn() {
        board.setMark(Mark.John);

        Mark actual = sut.getMarkAt(field);

        Mark expected = Mark.John;
        assertEquals(expected, actual);
    }

    @Test
    void IfBoardGetsAskedForMark_ItShouldAskTheBoardWithSameField() {
        BoardMock board = new BoardMock();
        ObservableBoard sut = new ObservableBoard(board);
        Field field = new Field(0, 1);
        board.expectGetMarkWith(field);

        sut.getMarkAt(field);

        board.verifyAll();
    }

    private class BoardMock extends BoardDummy {

        private boolean wasAskedForMark = false;
        private Field expectedField;
        private Field actualField;

        public Mark getMarkAt(Field f) {
            this.wasAskedForMark = true;
            this.actualField = f;
            return super.getMarkAt(f);
        }

        public void verifyAll() {
            assertTrue(wasAskedForMark);
            assertEquals(expectedField, actualField);
        }

        public void expectGetMarkWith(Field field) {
            this.expectedField = field;
        }
    }

}
