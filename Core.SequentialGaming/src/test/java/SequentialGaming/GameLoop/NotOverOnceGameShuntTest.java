package SequentialGaming.GameLoop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NotOverOnceGameShuntTest implements Game {

    private int timesNotOver = 1;
    private int timesIsOverCalled = 0;

    private String logString = "";

    @Test
    void IfGameIsNotOverOnce_ShouldHavePlayedBeforeRendering() {
        GameLoop sut = new GameLoop(this);
        this.timesNotOver = 1;

        sut.run();

        assertLogStringEquals("play render ");
    }

    private void assertLogStringEquals(String expected) {
        String actual = logString;
        assertEquals(expected, actual);
    }


    public boolean isOver() {
        return timesIsOverCalled++ >= timesNotOver;
    }

    public void play() {
        logString += "play ";
    }

    public void render() {
        logString += "render ";
    }
}
