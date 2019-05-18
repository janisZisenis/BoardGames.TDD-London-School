package Rendering.BoardRenderer;

import Domain.Data.Line.Line;

public class RenderingBoardViewSpy implements RenderingBoardView {

    private boolean didShowBoard = false;
    private boolean didShowWinningLine = false;
    private Line shownWinningLine = null;

    public void showBoard() {
        didShowBoard = true;
    }

    public void showWinningLine(Line line) {
        didShowWinningLine = true;
        shownWinningLine = line;
    }

    public boolean hasShownBoard() {
        return didShowBoard;
    }

    public Line getShownWinnineLine() {
        return shownWinningLine;
    }

    public boolean hasShownWinningLine() {
        return didShowWinningLine;
    }
}
