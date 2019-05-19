package Presentation.GameOverViewPresenter;

public interface GameOverInteractor {

    GameOverMessageResponse receive();
    void sendCancel();
    void sendReconfigure();
    void sendRestart();

}
