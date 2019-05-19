package Rendering.BoardRenderer;

import Domain.Data.Line.Line;

public interface RenderingBoardView {
    void showBoard();
    void showWinningLine(Line line);
}
