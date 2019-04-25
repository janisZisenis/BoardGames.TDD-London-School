package com.company.Model.Board.ObservableBoard.ForwardingTests;

import com.company.Model.Board.BoardDummy;
import com.company.Data.Field.Field;
import com.company.Data.Mark;
import com.company.Model.Board.ObservableBoard.ObservableBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MarkFieldForwardingTest {

    private BoardMock board = new BoardMock();
    private ObservableBoard sut = new ObservableBoard(board);
    private Field field;
    private Mark mark;

    @Test
    void IfARow0Column1GetsMarkedWithJohn_ItShouldMarkTheRow0Column1WithJohnOnTheBoard() {
        makeBoardExpectsJohnMarksRow0Column1();

        sut.mark(field, mark);

        board.verifyAll();
    }

    @Test
    void IfARow0Column2GetsMarkedWithHaley_ItShouldMarkTheRow0Column2WithHaleyOnTheBoard() {
        makeBoardExpectsHaleyMarksRow1Column2();

        sut.mark(field, mark);

        board.verifyAll();
    }

    private void makeBoardExpectsJohnMarksRow0Column1() {
        field = new Field(0, 1);
        mark = Mark.John;
        board.expectGetsMarkedWith(field, mark);
    }

    private void makeBoardExpectsHaleyMarksRow1Column2() {
        field = new Field(1, 2);
        mark = Mark.Haley;
        board.expectGetsMarkedWith(field, mark);
    }

    private class BoardMock extends BoardDummy {

        private boolean wasMarked = false;
        private Field expectedField;
        private Mark expectedMark;
        private Mark actualMark;
        private Field actualField;

        public void expectGetsMarkedWith(Field f, Mark m) {
            this.expectedField = f;
            this.expectedMark = m;
        }

        public void mark(Field f, Mark m) {
            this.wasMarked = true;
            this.actualField = f;
            this.actualMark = m;
        }

        public void verifyAll() {
            assertTrue(wasMarked);
            assertEquals(expectedField, actualField);
            assertEquals(expectedMark, actualMark);
        }

    }
}
