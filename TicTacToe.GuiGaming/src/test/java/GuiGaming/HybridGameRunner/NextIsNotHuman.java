package GuiGaming.HybridGameRunner;

import InputGeneration.Input.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class NextIsNotHuman {

    private HybridGameLoopSpy loop = new HybridGameLoopSpy();
    private HybridGameRunner sut = new HybridGameRunner(loop);

    @BeforeEach
    void setUp() {
        loop.nextIsHuman(false);
    }

    @Test
    void IfInputGetsProcessed_ShouldNotPlayInput() {
        Input input = new Input(0, 0);

        sut.process(input);

        assertHasNotPlayedInput();
    }

    private void assertHasNotPlayedInput() {
        boolean actual = loop.hasPlayedInput();
        assertFalse(actual);
    }



}
