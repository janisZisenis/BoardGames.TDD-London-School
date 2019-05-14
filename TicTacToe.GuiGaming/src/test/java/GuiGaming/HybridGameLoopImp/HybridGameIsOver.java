package GuiGaming.HybridGameLoopImp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HybridGameIsOver {

    private HybridGameStub game = new HybridGameStub();
    private HybridGameLoopImp sut = new HybridGameLoopImp(game);

    @BeforeEach
    void setUp() {
        game.setIsOver(true);
    }

    @Test
    void ShouldNotBePlayable() {
        assertIsNotPlayable();
    }

    private void assertIsNotPlayable() {
        boolean actual = sut.isPlayable();
        assertFalse(actual);
    }

    @Test
    void ShouldNotBeRunnable() {
        assertIsNotRunnable();
    }

    private void assertIsNotRunnable() {
        boolean actual = sut.isRunnable();
        assertFalse(actual);
    }

}
