package Lib.Model.BoardRenderer;

import Lib.Data.Line;

public class BoardViewSpy implements BoardView {

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
