package Presentation.ShellPresenter;

public interface Shell {
    void showWelcomeScreen();
    void addComingSoon(String gameName);
    void addGame(String gameName);
    void showGame(GameView gameView);
}
