package Presentation.GameOverViewPresenter;

public interface GameOverInteractor {

    GameOverViewResponse receive();
    void sendCancel();
    void sendReconfigure();
    void sendRestart();

}
