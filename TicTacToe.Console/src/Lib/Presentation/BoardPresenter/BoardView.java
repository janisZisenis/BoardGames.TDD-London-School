package Lib.Presentation.BoardPresenter;

import Lib.Data.Line;
import Lib.Model.Board.Board;

public interface BoardView {

    void display(Board board);
    void display(Board board, Line line);

}
