package InteractiveGaming.HybridGameRunner;

import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HybridGameLoopShunt implements HybridGame {

    private String logString = "";
    private boolean nextIsInputTurn = false;

    private HybridGameRunner sut = new HybridGameRunner(this);

    @Test
    void IfNextIsInputTurnAndGetsProcessed_ShouldPlayInputBeforeRun() {
        this.nextIsInputTurn = true;
        Input input = new Input(0, 0);

        sut.process(input);

        assertLogStringEquals("playInput runToNextInputTurn ");
    }

    @Test
    void IfGetsRun_ShouldRunToNextInputTurn() {
        sut.run();

        assertLogStringEquals("runToNextInputTurn ");
    }

    private void assertLogStringEquals(String expected) {
        String actual = logString;
        assertEquals(expected, actual);
    }

    public boolean nextIsInputTurn() {
        return nextIsInputTurn;
    }

    public void playInput(Input input) {
        logString += "playInput ";
    }

    public void runToNextInputTurn() {
        logString += "runToNextInputTurn ";
    }
}
