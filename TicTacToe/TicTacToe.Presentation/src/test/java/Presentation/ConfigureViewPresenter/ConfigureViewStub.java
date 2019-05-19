package Presentation.ConfigureViewPresenter;

public class ConfigureViewStub implements ConfigureView {

    private PlayerType firstPlayerType;
    private PlayerType secondPlayerType;

    public void setFirstPlayerType(PlayerType type) {
        firstPlayerType = type;
    }
    public PlayerType getFirstPlayerType() {
        return firstPlayerType;
    }

    public void setSecondPlayerType(PlayerType type) {
        secondPlayerType = type;
    }
    public PlayerType getSecondPlayerType() {
        return secondPlayerType;
    }

}
