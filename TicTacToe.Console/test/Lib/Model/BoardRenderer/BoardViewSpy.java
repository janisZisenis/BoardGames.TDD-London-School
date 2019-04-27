package Lib.Model.BoardRenderer;

import Lib.Data.Line;
import Lib.Model.Board.Board;
import Lib.Presentation.BoardPresenter.BoardView;

public class BoardViewSpy implements BoardView {

    private boolean didShowBoard = false;
    private boolean didShowWinningLine = false;
    private Line shownWinningLine = null;

    @Override
    public void display(Board board) {

    }

    @Override
    public void display(Board board, Line line) {

    }

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
