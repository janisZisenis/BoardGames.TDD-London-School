package com.company.Presentation.BoardPresenter;

import com.company.Model.Board.Board;
import com.company.Model.Board.ObservableBoard.Observer;
import com.company.Data.Line;

public class BoardPresenter implements Observer {

    private final Board board;
    private final BoardView view;
    private final WinningLineProvider provider;

    public BoardPresenter(BoardView view, Board board, WinningLineProvider provider) {
        this.board = board;
        this.view = view;
        this.provider = provider;
    }

    public void update() {
        if (hasWinningLine()) {
            displayBoardWithWinningLine();
        } else {
            displayBoard();
        }
    }

    private boolean hasWinningLine() {
        return provider.hasWinningLine();
    }

    private void displayBoard() {
        view.display(board);
    }

    private void displayBoardWithWinningLine() {
        Line winning = provider.getWinningLine();
        view.display(board, winning);
    }
}
