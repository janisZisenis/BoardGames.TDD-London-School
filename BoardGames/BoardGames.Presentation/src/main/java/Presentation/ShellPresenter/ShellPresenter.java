package Presentation.ShellPresenter;

import Presentation.ShellPresenter.Api.ShellDelegate;

import java.util.LinkedList;
import java.util.List;

public class ShellPresenter implements ShellDelegate {

    private final Shell shell;
    private final List<GameView> games = new LinkedList<>();

    public ShellPresenter(Shell shell) {
        this.shell = shell;
    }

    public void onViewDidShow() {
        shell.showWelcomeScreen();
    }

    public void showMainMenu() {
        shell.showWelcomeScreen();
    }

    public void addComingSoon(String gameName) {
        shell.addComingSoon(gameName);
    }

    public void addGame(GameView gameView, String gameName) {
        shell.addGame(gameName);
        games.add(gameView);
    }

    public void onGameClicked(int index) {
        if(index >= games.size())
            throw new GameIndexNotAvailable();

        GameView gameView = games.get(index);
        shell.showGame(gameView);
    }

    public class GameIndexNotAvailable extends RuntimeException {}

}
