package Presentation.ConfigureViewPresenter;

import Utilities.Transaction.TransactionSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ConfigureViewPresenterTest {

    private ConfigureViewSpy view = new ConfigureViewSpy();
    private TransactionSpy cancelAction = new TransactionSpy();
    private TransactionSpy startAction = new TransactionSpy();
    private ConfigureViewPresenter sut = new ConfigureViewPresenter(view, cancelAction, startAction);

    @Test
    void IfCancelButtonGetsClicked_ShouldExecuteCancelAction() {
        sut.onCancelClicked();

        assertHasExecutedCancelAction();
    }

    private void assertHasExecutedCancelAction() {
        boolean actual = cancelAction.hasExecuted();
        assertTrue(actual);
    }

//    @Test
//    void IfStartButtonGetsClicked_ShouldExecuteStartAction() {
//        sut.onStartClicked();
//
//        assertHasExecutedStartAction();
//    }
//
//    private void assertHasExecutedStartAction() {
//        boolean actual = startAction.hasExecuted();
//        assertTrue(actual);
//    }

}
