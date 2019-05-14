package GuiGaming.HybridGameLoopImp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HybridGameIsNotOver {

    private HybridGameStub game = new HybridGameStub();
    private HybridGameLoopImp sut = new HybridGameLoopImp(game);

    @BeforeEach
    void setUp() {
        game.setIsOver(false);
    }

    @Test
    void IfGameNeedsInput_ShouldBePlayable() {
        game.setNeedsInput(true);

        assertIsPlayable();
    }

    private void assertIsPlayable() {
        boolean actual = sut.isPlayable();
        assertTrue(actual);
    }

    @Test
    void IfGameDoesNotNeedInput_ShouldNotBePlayable() {
        game.setNeedsInput(false);

        assertIsNotPlayable();
    }

    private void assertIsNotPlayable() {
        boolean actual = sut.isPlayable();
        assertFalse(actual);
    }

    @Test
    void IfGameDoesNotNeedInput_ShouldBeRunnable() {
        game.setNeedsInput(false);

        assertIsRunnable();
    }

    @Test
    void IfGameNeedsInput_ShouldNotBeRunnable() {
        game.setNeedsInput(true);

        assertIsNotRunnable();
    }

    private void assertIsRunnable() {
        boolean actual = sut.isRunnable();
        assertTrue(actual);
    }

    private void assertIsNotRunnable() {
        boolean actual = sut.isRunnable();
        assertFalse(actual);
    }

}
