package InteractiveGaming.HybridGameRunner;

import Input2D.Input.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class NextIsNotInputTurn {

    private HybridGameSpy loop = new HybridGameSpy();
    private HybridGameRunner sut = new HybridGameRunner(loop);

    @BeforeEach
    void setUp() {
        loop.SetNextIsInputTurn(false);
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


    @Test
    void IfInputGetsProcessed_ShouldNotRunToNextInputTurn() {
        Input input = new Input(0, 0);

        sut.process(input);

        assertHasNotRunToNextInputTurn();
    }

    private void assertHasNotRunToNextInputTurn() {
        boolean actual = loop.hasRunToNextInputTurn();
        assertFalse(actual);
    }


}
