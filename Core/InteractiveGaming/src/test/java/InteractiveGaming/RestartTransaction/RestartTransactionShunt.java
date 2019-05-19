package InteractiveGaming.RestartTransaction;

import Gaming.GameLoopImp.Api.GameLoop;
import Gaming.RestartTransaction.ClearGameStateService;
import Gaming.RestartTransaction.ResetPlayerService;
import Gaming.RestartTransaction.RestartTransaction;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestartTransactionShunt implements ClearGameStateService, GameLoop, ResetPlayerService {

    private String logString = "";

    @Test
    void IfGetsRun_ShouldFirstClearBoardThenResetPlayersAndThenRun() {
        RestartTransaction sut = new RestartTransaction(this, this, this);

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
