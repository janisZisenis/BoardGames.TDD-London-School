package Presentation.WelcomeViewPresenter;

import Utilities.Transaction.TransactionMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OneActionAdded {

    private WelcomeViewSpy view = new WelcomeViewSpy();
    private WelcomeViewPresenter sut = new WelcomeViewPresenter(view);
    private TransactionMock action = new TransactionMock();

    @BeforeEach
    void setUp() {
        sut.addAction(action, "Name");
    }

    @Test
    void IfOneActionIsAddedAndClickedIndexIs0_ShouldExecuteAction() {
        action.expectGetsExecuted();

        sut.onActionClicked(0);

        action.verifyAll();
    }

    @Test
    void IfOneActionIsAddedAndClickedIndexIs1_ShouldThrow() {
        Executable act = () -> sut.onActionClicked(1);

        assertThrows(WelcomeViewPresenter.ActionIndexNotAvailable.class, act);
    }

}
