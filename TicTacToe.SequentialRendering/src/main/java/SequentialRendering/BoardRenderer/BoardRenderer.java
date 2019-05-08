package SequentialRendering.BoardRenderer;

import Domain.Data.Line.Line;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import SequentialGaming.DelegatingGame.Renderer;

public class BoardRenderer implements Renderer {

    private final BoardRenderingView view;
    private final WinningLineProvider provider;

    public BoardRenderer(BoardRenderingView view, WinningLineProvider provider) {
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
