package GuiGaming.HybridGameRunner;

import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HybridGameRunnerTest {

    private HybridGameLoopSpy loop = new HybridGameLoopSpy();
    private HybridGameRunner sut = new HybridGameRunner(loop);

    @Test
    void IfGetsRun_ShouldRunTheLoop() {
        sut.run();

        assertHasRun();
    }


    @Test
    void IfNeedsInputAndInputR0C0GetsProcessed_ShouldRunInputR0C0() {
        loop.setNeedsInput(true);
        Input input = new Input(0, 0);

        sut.process(input);

        assertRunInputEquals(new Input(0, 0));
    }

    @Test
    void IfNeedsInputAndInputR1C2GetsProcessed_ShouldRunInputR1C2() {
        loop.setNeedsInput(true);
        Input input = new Input(1, 2);

        sut.process(input);

        assertRunInputEquals(new Input(1, 2));
    }

    private void assertRunInputEquals(Input input) {
        Input actual = loop.getRunInput();
        Input expected = input;
        assertEquals(expected, actual);
    }


    @Test
    void IfNeedsInputWhileProcessing_ShouldRunTheLoop() {
        loop.setNeedsInput(true);
        Input input = new Input(1, 2);

        sut.process(input);

        assertHasRun();
    }

    private void assertHasRun() {
        boolean actual = loop.hasRun();
        assertTrue(actual);
    }


    @Test
    void IfDoesNotNeedInput_ShouldNotRunInput() {
        loop.setNeedsInput(false);
        Input input = new Input(0, 0);

        sut.process(input);

        assertHasNotRunInput();
    }

    private void assertHasNotRunInput() {
        boolean actual = loop.hasRunInput();
        assertFalse(actual);
    }


    @Test
    void IfDoesNotNeedInput_ShouldNotRunTheLoop() {
        loop.setNeedsInput(false);
        Input input = new Input(1, 2);

        sut.process(input);

        assertHasNotRun();
    }

    private void assertHasNotRun() {
        boolean actual = loop.hasRun();
        assertFalse(actual);
    }



}
