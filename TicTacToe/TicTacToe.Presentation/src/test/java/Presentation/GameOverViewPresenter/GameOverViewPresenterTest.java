package Presentation.GameOverViewPresenter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverViewPresenterTest {

    private GameOverViewSpy view = new GameOverViewSpy();
    private GameOverInteractorSpy interactor = new GameOverInteractorSpy();
    private GameOverViewPresenter sut = new GameOverViewPresenter(view, interactor);

    @Test
    void IfGameIsOverOnUpdate_ShouldShowTheResponseMessage() {
        GameOverMessageResponse response = makeGameIsOverResponseWith("Message");
        interactor.setResponse(response);

        sut.update();

        assertMessageWasShown("Message");
    }

    private GameOverMessageResponse makeGameIsOverResponseWith(String message) {
        boolean isGameOver = true;
        return new GameOverMessageResponse(isGameOver, message);
    }

    private void assertMessageWasShown(String expected) {
        String actual = view.getShownMessage();
        assertEquals(expected, actual);
    }


    @Test
    void IfGameIsNotOverOnUpdate_ShouldNotShowTheMessage() {
        GameOverMessageResponse response = makeGameIsNotOverResponse();
        interactor.setResponse(response);

        sut.update();

        assertHasNotShownMessage();
    }

    private GameOverMessageResponse makeGameIsNotOverResponse() {
        boolean isGameOver = false;
        String message = "Message";
        return new GameOverMessageResponse(isGameOver, message);
    }

    private void assertHasNotShownMessage() {
        boolean actual = view.hasShownMessage();
        assertFalse(actual);
    }


    @Test
    void IfCancelGetsClicked_ShouldSendCancel() {
        sut.onCancelClicked();

        assertHasSendCancel();
    }

    private void assertHasSendCancel() {
        boolean actual = interactor.hasSendCancel();
        assertTrue(actual);
    }


    @Test
    void IfReconfigureGetsClicked_ShouldSendReconfigure() {
        sut.onReconfigureClicked();

        assertHasSendReconfigure();
    }

    private void assertViewHasHidden() {
        boolean actual = view.hasHidden();
        assertTrue(actual);
    }


    private void assertHasSendReconfigure() {
        boolean actual = interactor.hasSendReconfigure();
        assertTrue(actual);
    }

    @Test
    void IfRestartGetsClicked_ShouldSendRestart() {
        sut.onRestartClicked();

        assertHasSendRestart();
    }


    @Test
    void IfCancelGetsClicked_ShouldHideTheGameOverView() {
        sut.onCancelClicked();

        assertViewHasHidden();
    }

    @Test
    void IfRestartGetsClicked_ShouldHideTheGameOverView() {
        sut.onRestartClicked();

        assertViewHasHidden();
    }

    @Test
    void IfReconfigureGetsClicked_ShouldHideTheGameOverView() {
        sut.onReconfigureClicked();

        assertViewHasHidden();
    }

    private void assertHasSendRestart() {
        boolean actual = interactor.hasSendRestart();
        assertTrue(actual);
    }

}
