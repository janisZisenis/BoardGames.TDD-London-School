package com.company.Presentation.BoardPresenter;

import com.company.Model.Board.Board;
import com.company.Data.Line;

public interface BoardView {

    void display(Board board);
    void display(Board board, Line line);

}
