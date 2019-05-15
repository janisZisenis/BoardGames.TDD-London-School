package HybridGaming.HybridGameRunner;

import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HybridGameLoopShunt implements HybridGame {

    private String logString = "";
    private boolean nextIsHuman = false;

    private HybridGameRunner sut = new HybridGameRunner(this);

    @Test
    void IfInputGetsProcessed_ShouldPlayInputBeforeComputerTurns() {
        this.nextIsHuman = true;
        Input input = new Input(0, 0);

        sut.process(input);

        assertLogStringEquals("playInput playComputerTurns ");
    }

    @Test
    void IfGetsRun_ShouldPlayComputerTurns() {
        sut.run();

        assertLogStringEquals("playComputerTurns ");
    }

    private void assertLogStringEquals(String expected) {
        String actual = logString;
        assertEquals(expected, actual);
    }

    public boolean nextIsHuman() {
        return nextIsHuman;
    }

    public void playHuman(Input input) {
        logString += "playInput ";
    }

    public void playComputerTurns() {
        logString += "playComputerTurns ";
    }
}
