package com.company.TicTacToe.BoardPresenter;

import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Line;

public interface BoardView {

    void display(Board board);
    void display(Board board, Line line);

}
