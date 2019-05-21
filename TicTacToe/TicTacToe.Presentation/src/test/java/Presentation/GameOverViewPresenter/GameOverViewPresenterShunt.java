package Presentation.GameOverViewPresenter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverViewPresenterShunt implements GameOverInteractor, GameOverView {

    private String logString = "";

    @Test
    void IfCancelGetsClicked_ShouldHideBeforeSendingCancel() {
        GameOverViewPresenter sut = new GameOverViewPresenter(this, this);

        sut.onCancelClicked();

        assertLogStringEquals("hide sendCancel ");
    }

    @Test
    void IfReconfigureGetsClicked_ShouldHideBeforeSendingReconfigure() {
        GameOverViewPresenter sut = new GameOverViewPresenter(this, this);

        sut.onReconfigureClicked();

        assertLogStringEquals("hide sendReconfigure ");
    }

    @Test
    void IfRestartGetsClicked_ShouldHideBeforeSendingRestart() {
        GameOverViewPresenter sut = new GameOverViewPresenter(this, this);

        sut.onRestartClicked();

        assertLogStringEquals("hide sendRestart ");
    }


    private void assertLogStringEquals(String expected) {
        String actual = logString;
        assertEquals(expected, actual);
    }

    public void showGameOverMessage(String message) {

    }

    public void hide() {
        logString += "hide ";
    }

    public GameOverMessageResponse receive() {
        return null;
    }

    public void sendCancel() {
        logString += "sendCancel ";
    }

    public void sendReconfigure() {
        logString += "sendReconfigure ";
    }

    public void sendRestart() {
        logString += "sendRestart ";
    }
}
