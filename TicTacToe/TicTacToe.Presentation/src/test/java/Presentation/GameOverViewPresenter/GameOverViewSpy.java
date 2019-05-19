package Presentation.GameOverViewPresenter;

import Presentation.GameOverViewPresenter.GameOverView;

public class GameOverViewSpy implements GameOverView {

    private boolean didShowMessage = false;
    private String message = "";
    private boolean didHide = false;

    public boolean hasShownMessage() {
        return didShowMessage;
    }
    public String getShownMessage() {
        return message;
    }
    public void showGameOverMessage(String message) {
        didShowMessage = true;
        this.message = message;
    }

    public boolean hasHidden() {
        return didHide;
    }
    public void hide() {
        didHide = true;
    }

}
