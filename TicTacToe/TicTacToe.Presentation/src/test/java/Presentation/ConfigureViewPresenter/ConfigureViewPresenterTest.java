package Presentation.ConfigureViewPresenter;

import Utilities.Transaction.TransactionSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfigureViewPresenterTest {

    private ConfigureViewSpy view = new ConfigureViewSpy();
    private IsStartableProviderStub provider = new IsStartableProviderStub();
    private TransactionSpy cancelAction = new TransactionSpy();
    private TransactionSpy startAction = new TransactionSpy();
    private ConfigureViewPresenter sut = new ConfigureViewPresenter(view, provider, cancelAction, startAction);

    @Test
    void IfIsNotStartableOnUpdate_ShouldDisableStartButton() {
        provider.setIsStartable(false);

        sut.update();

        assertHasDisabledStartButton();
    }

    @Test
    void IfIsStartableOnUpdate_ShouldEnableStartButton() {
        provider.setIsStartable(true);

        sut.update();

        assertHasEnabledStartButton();
    }

    @Test
    void IfIsNotStartableOnUpdate_ShouldNotEnableStartButton() {
        provider.setIsStartable(false);

        sut.update();

        assertHasNotEnabledStartButton();
    }

    @Test
    void IfIsStartableOnUpdate_ShouldNotDisableStartButton() {
        provider.setIsStartable(true);

        sut.update();

        assertHasNotDisabledStartButton();
    }


    @Test
    void IfIsNotStartableOnViewDidShow_ShouldDisableStartButton() {
        provider.setIsStartable(false);

        sut.onViewDidShow();

        assertHasDisabledStartButton();
    }

    @Test
    void IfIsStartableOnViewDidShow_ShouldEnableStartButton() {
        provider.setIsStartable(true);

        sut.onViewDidShow();

        assertHasEnabledStartButton();
    }

    @Test
    void IfIsNotStartableOnViewDidShow_ShouldNotEnableStartButton() {
        provider.setIsStartable(false);

        sut.onViewDidShow();

        assertHasNotEnabledStartButton();
    }

    @Test
    void IfIsStartableOnViewDidShow_ShouldNotDisableStartButton() {
        provider.setIsStartable(true);

        sut.onViewDidShow();

        assertHasNotDisabledStartButton();
    }

    private void assertHasNotDisabledStartButton() {
        boolean actual = view.hasDisabledStartButton();
        assertFalse(actual);
    }

    private void assertHasNotEnabledStartButton() {
        boolean actual = view.hasEnabledStartButton();
        assertFalse(actual);
    }

    private void assertHasEnabledStartButton() {
        boolean actual = view.hasEnabledStartButton();
        assertTrue(actual);
    }

    private void assertHasDisabledStartButton() {
        boolean actual = view.hasDisabledStartButton();
        assertTrue(actual);
    }


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
    void IfStartButtonGetsClicked_ShouldExecuteStartAction() {
        sut.onStartClicked();

        assertHasExecutedStartAction();
    }

    private void assertHasExecutedStartAction() {
        boolean actual = startAction.hasExecuted();
        assertTrue(actual);
    }

}
