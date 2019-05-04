package Bussiness.BoardRenderer;

import Data.Line.Line;
import Gaming.GameLoopImp.Renderer;

public class BoardRenderer implements Renderer {

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
