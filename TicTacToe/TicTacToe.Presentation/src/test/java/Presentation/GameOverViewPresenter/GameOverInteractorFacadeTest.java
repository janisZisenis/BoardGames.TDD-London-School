package Presentation.GameOverViewPresenter;

import GameLoopMessengerImp.MessageProviderStub;
import Gaming.GameFacade.GameOverRuleStub;
import Utilities.Transaction.TransactionSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverInteractorFacadeTest {

    private TransactionSpy cancelAction = new TransactionSpy();
    private TransactionSpy reconfigureAction = new TransactionSpy();
    private TransactionSpy restartAction = new TransactionSpy();
    private GameOverRuleStub rule = new GameOverRuleStub();
    private MessageProviderStub provider = new MessageProviderStub();
    private GameOverInteractorFacade sut = new GameOverInteractorFacade(rule, provider, cancelAction, reconfigureAction, restartAction);

    @Test
    void IfCancelGetsClicked_ShouldExecuteCancelAction() {
        sut.sendCancel();

        assertHasExecuted(cancelAction);
    }

    @Test
    void IfReconfigureGetsClicked_ShouldExecuteReconfigureAction() {
        sut.sendReconfigure();

        assertHasExecuted(reconfigureAction);
    }

    @Test
    void IfRestartGetsClicked_ShouldExecuteRestartAction() {
        sut.sendRestart();

        assertHasExecuted(restartAction);
    }

    private void assertHasExecuted(TransactionSpy action) {
        boolean actual = action.hasExecuted();
        assertTrue(actual);
    }


    @Test
    void IfRuleIsGameOver_TheResponseShouldBeOverEither() {
        rule.setIsGameOver(true);

        GameOverMessageResponse response = sut.receive();

        assertIsGameOver(response);
    }

    private void assertIsGameOver(GameOverMessageResponse response) {
        boolean actual = response.isGameOver();
        assertTrue(actual);
    }

    @Test
    void IfRuleIsNotGameOver_TheResponseShouldNotBeOverEither() {
        rule.setIsGameOver(false);

        GameOverMessageResponse response = sut.receive();

        assertIsNotGameOver(response);
    }

    private void assertIsNotGameOver(GameOverMessageResponse response) {
        boolean actual = response.isGameOver();
        assertFalse(actual);
    }


    @Test
    void IfMessageIsProvided_TheResponseShouldHaveTheMessageEither() {
        provider.setMessage("Message");

        GameOverMessageResponse response = sut.receive();

        assertHasMessage("Message", response);
    }

    private void assertHasMessage(String expected, GameOverMessageResponse response) {
        String actual = response.getMessage();
        assertEquals(expected, actual);
    }

}
