package Presentation.WelcomeViewPresenter;

import Utilities.Transaction.TransactionSpy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OneActionAdded {

    private WelcomeViewSpy view = new WelcomeViewSpy();
    private WelcomeViewPresenter sut = new WelcomeViewPresenter(view);
    private TransactionSpy action = new TransactionSpy();

    @BeforeEach
    void setUp() {
        sut.addAction(action, "Name");
    }

    @Test
    void IfOneActionIsAddedAndClickedIndexIs0_ShouldExecuteAction() {
        sut.onActionClicked(0);

        assertHasExecuted(action);
    }

    @Test
    void IfOneActionIsAddedAndClickedIndexIs1_ShouldThrow() {
        Executable act = () -> sut.onActionClicked(1);

        assertThrows(WelcomeViewPresenter.ActionIndexNotAvailable.class, act);
    }

    private void assertHasExecuted(TransactionSpy action) {
        boolean actual = action.hasExecuted();
        assertTrue(actual);
    }

}
