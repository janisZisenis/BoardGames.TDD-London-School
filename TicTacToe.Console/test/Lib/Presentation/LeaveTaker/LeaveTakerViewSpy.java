package Lib.Presentation.LeaveTaker;

import Lib.Data.Mark;

public class LeaveTakerViewSpy implements LeaveTakerView {

    private Mark shownWinner;
    private boolean didShowDraw = false;
    private boolean didShowWinner = false;

    public void showWinner(Mark winner) {
        didShowWinner = true;
        shownWinner = winner;
    }
    public Mark getShownWinner() {
        return shownWinner;
    }

    public boolean hasShownDraw() {
        return didShowDraw;
    }
    public void showDraw() { didShowDraw = true; }

    public boolean hasShownWinner() {
        return didShowWinner;
    }
}
