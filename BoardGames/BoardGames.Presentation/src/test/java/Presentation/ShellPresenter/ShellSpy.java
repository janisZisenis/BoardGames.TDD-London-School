package Presentation.ShellPresenter;

public class ShellSpy implements Shell {

    private boolean didShowWelcomeScreen = false;
    private String addedComingSoon = "";
    private String addedGame = "";
    private GameView shownGameView;

    public boolean hasShownWelcomeScreen() {
        return didShowWelcomeScreen;
    }
    public void showWelcomeScreen() {
        didShowWelcomeScreen = true;
    }

    public String getAddedComingSoon() {
        return addedComingSoon;
    }
    public void addComingSoon(String gameName) {
        addedComingSoon = gameName;
    }

    public String getAddedGame() {
        return addedGame;
    }
    public void addGame(String gameName) {
        addedGame = gameName;
    }

    public GameView getShownGameView() {
        return shownGameView;
    }
    public void showGame(GameView gameView) {
        shownGameView = gameView;
    }

}
