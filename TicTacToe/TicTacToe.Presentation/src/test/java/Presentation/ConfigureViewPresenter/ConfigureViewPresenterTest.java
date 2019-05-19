package Presentation.ConfigureViewPresenter;

import Utilities.Transaction.TransactionSpy;
import org.junit.jupiter.api.Test;

import static Presentation.ConfigureViewPresenter.PlayerType.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfigureViewPresenterTest {

    private ConfigureViewStub view = new ConfigureViewStub();
    private TransactionSpy cancelAction = new TransactionSpy();
    private RunInteractorSpy interactor = new RunInteractorSpy();
    private ConfigureViewPresenter sut = new ConfigureViewPresenter(view, cancelAction, interactor);

    @Test
    void IfCancelButtonGetsClicked_ShouldExecuteCancelAction() {
        sut.onCancelClicked();

        assertHasExecutedCancelAction();
    }

    private void assertHasExecutedCancelAction() {
        boolean actual = cancelAction.hasExecuted();
        assertTrue(actual);
    }

    @Test
    void IfFirstPlayerTypeIsHumanOnStartClicked_RequestShouldHaveHumanAsFirstPlayerTypeToo() {
        view.setFirstPlayerType(Human);

        sut.onStartClicked();

        RunRequest request = interactor.getSentRequest();
        assertFirstPlayerTypeEquals(Human, request);
    }

    @Test
    void IfFirstPlayerTypeIsInvincibleCPUOnStartClicked_RequestShouldHaveInvincibleCPUAsFirstPlayerTypeToo() {
        view.setFirstPlayerType(InvincibleCPU);

        sut.onStartClicked();

        RunRequest request = interactor.getSentRequest();
        assertFirstPlayerTypeEquals(InvincibleCPU, request);
    }

    private void assertFirstPlayerTypeEquals(PlayerType expected, RunRequest request) {
        PlayerType actual = request.getFirstPlayerType();
        assertEquals(expected, actual);
    }


    @Test
    void IfSecondPlayerTypeIsHumanOnStartClicked_RequestShouldHaveHumanAsSecondPlayerTypeToo() {
        view.setSecondPlayerType(Human);

        sut.onStartClicked();

        RunRequest request = interactor.getSentRequest();
        assertSecondPlayerTypeEquals(Human, request);
    }

    @Test
    void IfSecondPlayerTypeIsInvincibleCPUOnStartClicked_RequestShouldHaveInvincibleCPUAsSecondPlayerTypeToo() {
        view.setSecondPlayerType(InvincibleCPU);

        sut.onStartClicked();

        RunRequest request = interactor.getSentRequest();
        assertSecondPlayerTypeEquals(InvincibleCPU, request);
    }


    private void assertSecondPlayerTypeEquals(PlayerType expected, RunRequest request) {
        PlayerType actual = request.getSecondPlayerType();
        assertEquals(expected, actual);
    }


}
