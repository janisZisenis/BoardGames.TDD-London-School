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
        interactor.sendCancel();
        view.hide();
    }

    public void onReconfigureClicked() {
        interactor.sendReconfigure();
        view.hide();
    }

    public void onRestartClicked() {
        interactor.sendRestart();
        view.hide();
    }
}
