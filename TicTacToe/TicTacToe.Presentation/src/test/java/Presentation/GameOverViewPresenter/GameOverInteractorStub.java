package Presentation.GameOverViewPresenter;

public class GameOverInteractorStub implements GameOverInteractor {

    private GameOverMessageResponse response;

    public void setResponse(GameOverMessageResponse response) {
        this.response = response;
    }
    public GameOverMessageResponse receive() {
        return response;
    }

    public void sendCancel() {}
    public void sendReconfigure() {}
    public void sendRestart() {}

}
