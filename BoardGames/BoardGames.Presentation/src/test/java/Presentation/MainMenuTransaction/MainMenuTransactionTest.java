package Presentation.MainMenuTransaction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainMenuTransactionTest {

    private MainMenuPresenterSpy presenter = new MainMenuPresenterSpy();
    private MainMenuTransaction sut = new MainMenuTransaction(presenter);

    @Test
    void IfGetsExecuted_ShouldShowMainMenu() {
        sut.execute();

        assertHasShownMainMenu();
    }

    private void assertHasShownMainMenu() {
        boolean actual = presenter.hasShownMainMenu();
        assertTrue(actual);
    }
    
}
