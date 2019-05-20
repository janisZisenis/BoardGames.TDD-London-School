package Gaming.GameFacade;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerMock extends PlayerDummy {

    private boolean expectedDidPlay = false;
    private boolean actualDidPlay = false;

    private int actualTimes = 0;
    private int expectedTimes = 0;

    public void play() {
        actualDidPlay = true;
        actualTimes++;
    }

    public void expectGetsPlayedTimes(int times) {
        expectedDidPlay = true;
        expectedTimes = times;
    }

    public void verifyAll() {
        assertEquals(expectedDidPlay, actualDidPlay);
        assertEquals(expectedTimes, actualTimes);
    }
}
