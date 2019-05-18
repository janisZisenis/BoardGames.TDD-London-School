package Presentation.Transactions.LoadGameViewTransaction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoadGameViewTransactionTest {

    private GameViewDummy view = new GameViewDummy();
    private GameViewLoaderSpy loader = new GameViewLoaderSpy();
    private LoadGameViewTransaction sut = new LoadGameViewTransaction(view, loader);

    @Test
    void IfGetsExecuted_ShouldLoadTheView() {
        sut.execute();

        assertHasLoadedView();
    }

    private void assertHasLoadedView() {
        GameView actual = loader.getLoadedGameView();
        GameView expected = view;
        assertEquals(expected, actual);
    }

}
