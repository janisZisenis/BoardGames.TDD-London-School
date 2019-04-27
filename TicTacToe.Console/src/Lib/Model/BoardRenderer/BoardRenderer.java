package Lib.Model.BoardRenderer;

import Lib.Data.Line;
import Lib.Presentation.BoardPresenter.BoardView;
import Lib.Presentation.BoardPresenter.WinningLineProvider;

public class BoardRenderer {

    private final BoardView view;
    private final WinningLineProvider provider;

    public BoardRenderer(BoardView view, WinningLineProvider provider) {
        this.view = view;
        this.provider = provider;
    }

    public void render() {
        if (!provider.hasWinningLine()) {
            view.showBoard();
        } else {
            Line line = provider.getWinningLine();
            view.showWinningLine(line);
        }
    }

}
