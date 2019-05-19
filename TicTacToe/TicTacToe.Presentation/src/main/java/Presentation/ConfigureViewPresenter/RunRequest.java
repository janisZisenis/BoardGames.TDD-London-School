package Presentation.ConfigureViewPresenter;

public class RunRequest {

    private final PlayerType first;
    private final PlayerType second;

    public RunRequest(PlayerType first, PlayerType second) {
        this.first = first;
        this.second = second;
    }

    public PlayerType getFirstPlayerType() {
        return first;
    }

    public PlayerType getSecondPlayerType() {
        return second;
    }
}
