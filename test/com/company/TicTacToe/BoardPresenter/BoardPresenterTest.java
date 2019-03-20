package com.company.TicTacToe.BoardPresenter;

import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.BoardDummy;
import com.company.TicTacToe.Board.Field.Field;
import com.company.TicTacToe.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardPresenterTest {

    private WinningLineProviderStub provider = new WinningLineProviderStub();
    private BoardDummy board = new BoardDummy();
    private BoardViewMock view = new BoardViewMock();
    private BoardPresenter sut = new BoardPresenter(view, board, provider);

    private Line winning = new Line(new Field(0, 0),
                                    new Field(0, 1),
                                    new Field(0, 2));

    @Test
    void IfNoWinningLineIsProvdied_ViewHasDisplayedBoardOnUpdate() {
        view.expectHasDisplayed(board);

        sut.update();

        view.verifyAll();
    }

    @Test
    void IfWinningLineIsProvdied_ViewHasDisplayedWinningLineOnUpdate() {
        provider.setWinningLine(winning);
        view.expectHasDisplayedWithLine(board, winning);

        sut.update();

        view.verifyAll();
    }

    private class BoardViewMock implements BoardView {

        private boolean actualDisplayed = false;
        private boolean expectedDisplayed = false;
        private boolean actualDisplayedWithLine = false;
        private boolean expectedDisplayedWithLine = false;

        private Board actualBoard;
        private Board expectedBoard;
        private Line actualLine;
        private Line expectedLine;


        public void display(Board board) {
            actualDisplayed = true;
            actualBoard = board;
        }

        public void expectHasDisplayed(Board board) {
            this.expectedDisplayed = true;
            this.expectedBoard = board;
        }

        public void display(Board board, Line line) {
            actualDisplayedWithLine = true;
            actualBoard = board;
            actualLine = line;
        }

        public void expectHasDisplayedWithLine(Board board, Line line) {
            this.expectedDisplayedWithLine = true;
            this.expectedBoard = board;
            this.expectedLine = line;
        }

        private void verifyAll() {
            assertEquals(expectedDisplayed, actualDisplayed);
            assertEquals(expectedDisplayedWithLine, actualDisplayedWithLine);
            assertEquals(expectedBoard, actualBoard);
            assertEquals(expectedLine, actualLine);
        }
    }
}
