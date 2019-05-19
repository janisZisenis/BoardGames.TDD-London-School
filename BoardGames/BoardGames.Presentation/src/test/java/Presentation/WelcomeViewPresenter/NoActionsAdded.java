package Presentation.WelcomeViewPresenter;

import Utilities.Transaction.TransactionDummy;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NoActionsAdded {

    private WelcomeViewSpy view = new WelcomeViewSpy();
    private WelcomeViewPresenter sut = new WelcomeViewPresenter(view);

    @Test
    void IfComingSoonGetsAdded_ShouldAddComingSoon() {
        String name = "Name";

        sut.addComingSoonAction(name);

        assertHasAddedComingSoon(name);
    }

    private void assertHasAddedComingSoon(String expected) {
        String actual = view.getAddedComingSoonActionName();
        assertEquals(expected, actual);
    }


    @Test
    void IfActionGetsAdded_ShouldAddActionName() {
        String name = "Name";
        TransactionDummy action = new TransactionDummy();

        sut.addAction(action, name);

        assertHasAddedActionName(name);
    }

    private void assertHasAddedActionName(String expected) {
        String actual = view.getAddedActionName();
        assertEquals(expected, actual);
    }


    @Test
    void IfClickedIndexIs1_ShouldThrow() {
        Executable act = () -> sut.onActionClicked(0);

        assertThrows(WelcomeViewPresenter.ActionIndexNotAvailable.class, act);
    }

    @Test
    void IfClickedIndexIsMinus1_ShouldThrow() {
        Executable act = () -> sut.onActionClicked(-1);

        assertThrows(WelcomeViewPresenter.ActionIndexNotAvailable.class, act);
    }

}
