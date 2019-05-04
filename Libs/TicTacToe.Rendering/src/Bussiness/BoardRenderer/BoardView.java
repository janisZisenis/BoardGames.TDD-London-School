package Bussiness.BoardRenderer;

import Domain.Data.Line.Line;

public interface BoardView {
    void showBoard();
    void showWinningLine(Line line);
}
