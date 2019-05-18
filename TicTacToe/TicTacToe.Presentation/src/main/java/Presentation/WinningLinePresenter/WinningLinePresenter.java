package Presentation.WinningLinePresenter;

import Domain.Data.Line.Line;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Utilities.Observer.Observer;

public class WinningLinePresenter implements Observer {

    private final WinningLineProvider provider;
    private final WinningLineView view;

    public WinningLinePresenter(WinningLineView view, WinningLineProvider provider) {
        this.view = view;
        this.provider = provider;
    }

    public void update() {
        if(provider.hasWinningLine()) {
            Line line = provider.getWinningLine();
            view.highlightLine(line);
        }
    }
}
