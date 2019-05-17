package Presentation.ShellPresenter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class ShellPresenterTest {

    private ShellSpy shell = new ShellSpy();
    private ShellPresenter sut = new ShellPresenter(shell);

    @Test
    void IfViewDidShow_ShouldShowWelcomeScreen() {
        sut.onViewDidShow();

        assertHasShownWelcomeScreen();
    }

    @Test
    void IfMainMenuGetsShown_ShouldShowWelcomeScreen() {
        sut.showMainMenu();

        assertHasShownWelcomeScreen();
    }

    private void assertHasShownWelcomeScreen() {
        boolean actual = shell.hasShownWelcomeScreen();
        assertTrue(actual);
    }

    @Test
    void IfComingSoonGetsAdded_ShouldAddComingSoon() {
        String gameName = "Name";

        sut.addComingSoon(gameName);

        assertHasAddedComingSoon(gameName);
    }

    private void assertHasAddedComingSoon(String expected) {
        String actual = shell.getAddedComingSoon();
        assertEquals(expected, actual);
    }


    @Test
    void IfGameGetsAdded_ShouldAddGame() {
        String gameName = "Name";
        GameViewDummy gameView = new GameViewDummy();

        sut.addGame(gameView, gameName);

        assertHasAddedGame(gameName);
    }

    private void assertHasAddedGame(String expected) {
        String actual = shell.getAddedGame();
        assertEquals(expected, actual);
    }


    @Test
    void IfNoGamesAreAdded_ShouldThrowOnGameClicked() {
        Executable act = () -> sut.onGameClicked(0);

        assertThrows(ShellPresenter.GameIndexNotAvailable.class, act);
    }

    @Test
    void IfOneGameIsAddedAndClickedIndexIs0_ShouldShowGame() {
        GameViewDummy gameView = new GameViewDummy();
        sut.addGame(gameView, "Name");

        sut.onGameClicked(0);

        assertHasShownGameView(gameView);
    }

    @Test
    void IfOneGameIsAddedAndClickedIndexIs1_ShouldThrow() {
        GameViewDummy gameView = new GameViewDummy();
        sut.addGame(gameView, "Name");

        Executable act = () -> sut.onGameClicked(1);

        assertThrows(ShellPresenter.GameIndexNotAvailable.class, act);
    }

    @Test
    void IfTwoGamesAddedAndClickedIndexIs0_ShouldShowFirstGame() {
        GameViewDummy first = new GameViewDummy();
        sut.addGame(first, "Name");
        GameViewDummy second = new GameViewDummy();
        sut.addGame(second, "Name");


        sut.onGameClicked(0);

        assertHasShownGameView(first);
    }

    @Test
    void IfTwoGamesAddedAndClickedIndexIs1_ShouldShowSecondGame() {
        GameViewDummy first = new GameViewDummy();
        sut.addGame(first, "Name");
        GameViewDummy second = new GameViewDummy();
        sut.addGame(second, "Name");


        sut.onGameClicked(1);

        assertHasShownGameView(second);
    }

    private void assertHasShownGameView(GameViewDummy expected) {
        GameView actual = shell.getShownGameView();
        assertEquals(expected, actual);
    }

}
