package Presentation.GameOverView.GameOverViewInteractorFacade;

import Gaming.GameFacade.GameOverRuleStub;
import Messaging.GameLoopMessengerImp.MessageProviderStub;
import Presentation.GameOverView.GameOverViewPresenter.GameOverViewResponse;
import Utilities.Transaction.TransactionSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

        GameOverViewResponse response = sut.receive();

        assertIsGameOver(response);
    }

    private void assertIsGameOver(GameOverViewResponse response) {
        boolean actual = response.isGameOver();
        assertTrue(actual);
    }

    @Test
    void IfRuleIsNotGameOver_TheResponseShouldNotBeOverEither() {
        rule.setIsGameOver(false);

        GameOverViewResponse response = sut.receive();

        assertIsNotGameOver(response);
    }

    private void assertIsNotGameOver(GameOverViewResponse response) {
        boolean actual = response.isGameOver();
        assertFalse(actual);
    }


    @Test
    void IfMessageIsProvided_TheResponseShouldHaveTheMessageEither() {
        provider.setMessage("Message");

        GameOverViewResponse response = sut.receive();

        assertHasMessage("Message", response);
    }

    private void assertHasMessage(String expected, GameOverViewResponse response) {
        String actual = response.getMessage();
        assertEquals(expected, actual);
    }

}
