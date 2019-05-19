package Presentation.GameOverViewPresenter;

import Presentation.GameOverViewPresenter.Api.GameOverViewDelegate;
import Utilities.Observer.Observer;

public class GameOverViewPresenter implements GameOverViewDelegate, Observer {

    private final GameOverInteractor interactor;
    private final GameOverView view;

    public GameOverViewPresenter(GameOverView view, GameOverInteractor interactor) {
        this.interactor = interactor;
        this.view = view;
    }

    public void update() {
        GameOverMessageResponse response = interactor.receive();

        if(response.isGameOver()) {
            String message = response.getMessage();
            view.showGameOverMessage(message);
        }
    }

    public void onCancelClicked() {
        view.hide();
        interactor.sendCancel();
    }

    public void onReconfigureClicked() {
        view.hide();
        interactor.sendReconfigure();
    }

    public void onRestartClicked() {
        view.hide();
        interactor.sendRestart();
    }
}
