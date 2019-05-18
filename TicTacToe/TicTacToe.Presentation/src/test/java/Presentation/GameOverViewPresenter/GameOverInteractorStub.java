package Presentation.GameOverViewPresenter;

import Presentation.GameOverViewPresenter.GameOverInteractor;
import Presentation.GameOverViewPresenter.GameOverViewResponse;

public class GameOverInteractorStub implements GameOverInteractor {

    private GameOverViewResponse response;

    public void setResponse(GameOverViewResponse response) {
        this.response = response;
    }
    public GameOverViewResponse receive() {
        return response;
    }

    public void sendCancel() {}
    public void sendReconfigure() {}
    public void sendRestart() {}

}
