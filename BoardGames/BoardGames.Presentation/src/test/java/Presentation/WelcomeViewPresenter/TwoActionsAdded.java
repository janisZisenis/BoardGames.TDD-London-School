package Presentation.WelcomeViewPresenter;

import Utilities.Transaction.TransactionSpy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TwoActionsAdded {

    private WelcomeViewSpy view = new WelcomeViewSpy();
    private WelcomeViewPresenter sut = new WelcomeViewPresenter(view);
    private TransactionSpy first = new TransactionSpy();
    private TransactionSpy second = new TransactionSpy();

    @BeforeEach
    void setUp() {
        sut.addAction(first, "Name");
        sut.addAction(second, "Name");
    }

    @Test
    void IfTwoActionsAreAddedAndClickedIndexIs0_ShouldExecuteFirstFirst() {
        sut.onActionClicked(0);

        assertHasExecuted(first);
    }

    @Test
    void IfTwoActionsAreAddedAndClickedIndexIs1_ShouldExecuteSecondAction() {
        sut.onActionClicked(1);

        assertHasExecuted(second);
    }

    @Test
    void IfTwoActionsAreAddedAndClickedIndexIs3_ShouldThrow() {
        Executable act = () -> sut.onActionClicked(3);

        assertThrows(WelcomeViewPresenter.ActionIndexNotAvailable.class, act);
    }

    private void assertHasExecuted(TransactionSpy action) {
        boolean actual = action.hasExecuted();
        assertTrue(actual);
    }

}
