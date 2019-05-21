package Presentation.GameOverViewPresenter;

import GameLoopMessengerImp.MessageProviderStub;
import Gaming.GameFacade.GameOverRuleStub;
import Utilities.Transaction.TransactionMock;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverInteractorFacadeTest {

    private TransactionMock cancelAction = new TransactionMock();
    private TransactionMock reconfigureAction = new TransactionMock();
    private TransactionMock restartAction = new TransactionMock();
    private GameOverRuleStub rule = new GameOverRuleStub();
    private MessageProviderStub provider = new MessageProviderStub();
    private GameOverInteractorFacade sut = new GameOverInteractorFacade(rule, provider, cancelAction, reconfigureAction, restartAction);

    @Test
    void IfCancelGetsClicked_ShouldExecuteCancelAction() {
        cancelAction.expectGetsExecuted();

        sut.sendCancel();

        cancelAction.verifyAll();
    }

    @Test
    void IfReconfigureGetsClicked_ShouldExecuteReconfigureAction() {
        reconfigureAction.expectGetsExecuted();

        sut.sendReconfigure();

        reconfigureAction.verifyAll();
    }

    @Test
    void IfRestartGetsClicked_ShouldExecuteRestartAction() {
        restartAction.expectGetsExecuted();

        sut.sendRestart();

        restartAction.verifyAll();
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
