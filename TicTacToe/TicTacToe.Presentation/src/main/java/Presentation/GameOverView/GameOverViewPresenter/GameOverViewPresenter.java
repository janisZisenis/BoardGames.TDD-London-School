package Presentation.GameOverView.GameOverViewPresenter;

public class GameOverViewPresenter {

    private final GameOverInteractor interactor;
    private final GameOverView view;

    public GameOverViewPresenter(GameOverView view, GameOverInteractor interactor) {
        this.interactor = interactor;
        this.view = view;
    }

    public void update() {
        GameOverViewResponse response = interactor.receive();

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
