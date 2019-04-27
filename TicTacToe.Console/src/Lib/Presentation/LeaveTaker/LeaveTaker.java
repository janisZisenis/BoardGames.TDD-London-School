package Lib.Presentation.LeaveTaker;

import Lib.Data.Mark;

public class LeaveTaker {

    private final WinnerProvider provider;
    private final LeaveTakerView view;

    public LeaveTaker(WinnerProvider provider, LeaveTakerView view) {
        this.provider = provider;
        this.view = view;
    }

    public void showLeaveTaking() {
        if(provider.hasWinner()) {
            Mark winner = provider.getWinner();
            view.showWinner(winner);
        } else {
            view.showDraw();
        }
    }
}
