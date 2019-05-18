package Presentation.GameOverView.GameOverViewPresenter;

public interface GameOverInteractor {

    GameOverViewResponse receive();
    void sendCancel();
    void sendReconfigure();
    void sendRestart();

}
