package Presentation.WelcomeViewPresenter;

import Utilities.Transaction.TransactionMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TwoActionsAdded {

    private WelcomeViewSpy view = new WelcomeViewSpy();
    private WelcomeViewPresenter sut = new WelcomeViewPresenter(view);
    private TransactionMock first = new TransactionMock();
    private TransactionMock second = new TransactionMock();

    @BeforeEach
    void setUp() {
        sut.addAction(first, "Name");
        sut.addAction(second, "Name");
    }

    @Test
    void IfTwoActionsAreAddedAndClickedIndexIs0_ShouldExecuteFirstFirst() {
        first.expectGetsExecuted();

        sut.onActionClicked(0);

        first.verifyAll();
    }

    @Test
    void IfTwoActionsAreAddedAndClickedIndexIs1_ShouldExecuteSecondAction() {
        second.expectGetsExecuted();

        sut.onActionClicked(1);

        second.verifyAll();
    }

    @Test
    void IfTwoActionsAreAddedAndClickedIndexIs3_ShouldThrow() {
        Executable act = () -> sut.onActionClicked(3);

        assertThrows(WelcomeViewPresenter.ActionIndexNotAvailable.class, act);
    }

}
