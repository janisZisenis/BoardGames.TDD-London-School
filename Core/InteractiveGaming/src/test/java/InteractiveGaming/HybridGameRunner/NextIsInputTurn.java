package InteractiveGaming.HybridGameRunner;

import Input2D.Input.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NextIsInputTurn {

    private HybridGameSpy loop = new HybridGameSpy();
    private HybridGameRunner sut = new HybridGameRunner(loop);

    @BeforeEach
    void setUp() {
        loop.SetNextIsInputTurn(true);
    }


    @Test
    void IfInputR1C2GetsProcessed_ShouldPlayedInputR1C2() {
        Input input = new Input(1, 2);

        sut.process(input);

        assertPlayedInputEquals(input);
    }

    private void assertPlayedInputEquals(Input input) {
        Input actual = loop.getPlayedInput();
        Input expected = input;
        assertEquals(expected, actual);
    }

}
