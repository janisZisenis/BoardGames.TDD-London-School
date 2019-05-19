package MessagingGameLoop;

import Gaming.GameLoopImp.Api.GameLoop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessagingGameLoopShunt implements GameLoop, GameLoopMessenger {

    private String logString = "";

    @Test
    void ShouldPublishTheStartBeforeAndTheEndAfterRunning() {
        MessagingGameLoop sut = new MessagingGameLoop(this, this);

        sut.run();

        assertLogStringIs("publishStart run publishEnd ");
    }

    private void assertLogStringIs(String expected) {
        String actual = logString;
        assertEquals(expected, actual);
    }

    public void run() {
        logString += "run ";
    }

    public void publishStart() {
        logString += "publishStart ";
    }

    public void publishEnd() {
        logString += "publishEnd ";
    }
}
