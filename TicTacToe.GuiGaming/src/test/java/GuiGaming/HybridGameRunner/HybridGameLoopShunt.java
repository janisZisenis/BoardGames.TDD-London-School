package GuiGaming.HybridGameRunner;

import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HybridGameLoopShunt implements HybridGameLoop {

    private String logString = "";
    private boolean needsInput = false;

    private HybridGameRunner sut = new HybridGameRunner(this);

    @Test
    void IfNeedsInput_ShouldRunInputBeforeRun() {
        this.needsInput = true;
        Input input = new Input(0, 0);

        sut.process(input);

        assertLogStringEquals("runInput run ");
    }

    private void assertLogStringEquals(String expected) {
        String actual = logString;
        assertEquals(expected, actual);
    }

    public boolean needsInput() {
        return needsInput;
    }

    public void run(Input input) {
        logString += "runInput ";
    }

    public void run() {
        logString += "run ";
    }
}
