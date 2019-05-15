package HybridGaming.HybridGameRunner;

import InputGeneration.Input.Input;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NextIsHuman {

    private HybridGameLoopSpy loop = new HybridGameLoopSpy();
    private HybridGameRunner sut = new HybridGameRunner(loop);

    @BeforeEach
    void setUp() {
        loop.nextIsHuman(true);
    }


    @Test
    void IfR0C0GetsProcessed_ShouldPlayedInputR0C0() {
        Input input = new Input(0, 0);

        sut.process(input);

        assertPlayedInputEquals(new Input(0, 0));
    }

    @Test
    void IfInputR1C2GetsProcessed_ShouldPlayedInputR1C2() {
        Input input = new Input(1, 2);

        sut.process(input);

        assertPlayedInputEquals(new Input(1, 2));
    }

    private void assertPlayedInputEquals(Input input) {
        Input actual = loop.getPlayedInput();
        Input expected = input;
        assertEquals(expected, actual);
    }


    @Test
    void IfInputGetsProcessed_ShouldPlayComputerTurns() {
        Input input = new Input(1, 2);

        sut.process(input);

        assertHasPlayedComputerTurns();
    }

    private void assertHasPlayedComputerTurns() {
        boolean actual = loop.hasPlayedComputerTurns();
        assertTrue(actual);
    }



}
