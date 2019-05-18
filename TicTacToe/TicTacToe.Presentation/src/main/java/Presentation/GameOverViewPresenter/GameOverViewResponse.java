package Presentation.GameOverViewPresenter;

public class GameOverViewResponse {

    private final boolean isGameOver;
    private final String message;

    public GameOverViewResponse(boolean isGameOver, String message) {
        this.isGameOver = isGameOver;
        this.message = message;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public String getMessage() {
        return message;
    }

}
