package InteractiveGaming.ResetTransaction;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResetTransactionShunt implements ClearGameStateService, GameRunner, ResetPlayerService {

    private String logString = "";

    @Test
    void IfGetsRun_ShouldFirstClearBoardThenResetPlayersAndThenRun() {
        ResetTransaction sut = new ResetTransaction(this, this, this);

        sut.execute();

        assertLogStringEquals("clear reset run ");
    }

    private void assertLogStringEquals(String expected) {
        String actual = logString;
        assertEquals(expected, actual);
    }

    public void clear() {
        logString += "clear ";
    }

    public void run() {
        logString += "run ";
    }

    public void reset() {
        logString += "reset ";
    }
}
