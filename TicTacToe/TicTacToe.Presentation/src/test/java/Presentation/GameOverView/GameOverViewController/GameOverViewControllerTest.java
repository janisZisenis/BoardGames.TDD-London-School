package Presentation.GameOverView.GameOverViewController;

import Utilities.Transaction.TransactionSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameOverViewControllerTest {

    private TransactionSpy cancelAction = new TransactionSpy();
    private TransactionSpy reconfigureAction = new TransactionSpy();
    private TransactionSpy restartAction = new TransactionSpy();
    private GameOverViewController sut = new GameOverViewController(cancelAction, reconfigureAction, restartAction);

    @Test
    void IfCancelGetsClicked_ShouldExecuteCancelAction() {
        sut.onCancelClicked();

        assertHasExecuted(cancelAction);
    }

    @Test
    void IfReconfigureGetsClicked_ShouldExecuteReconfigureAction() {
        sut.onReconfigureClicked();

        assertHasExecuted(reconfigureAction);
    }

    @Test
    void IfRestartGetsClicked_ShouldExecuteRestartAction() {
        sut.onRestartClicked();

        assertHasExecuted(restartAction);
    }

    private void assertHasExecuted(TransactionSpy action) {
        boolean actual = action.hasExecuted();
        assertTrue(actual);
    }

}
