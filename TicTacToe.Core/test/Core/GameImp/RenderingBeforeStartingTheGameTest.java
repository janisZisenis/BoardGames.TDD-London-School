package Core.GameImp;

import Core.GameLoopImp.Renderer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RenderingBeforeStartingTheGameTest implements Renderer, GameLoop {

    private String logString = "";

    @Test
    void FreshInstance_ShouldFirstRenderTheGameOnceBeforeRunningTheLoop() {
        GameImp sut = new GameImp(this, this);

        sut.play();

        assertLogStringIs("render run ");
    }

    private void assertLogStringIs(String expected) {
        String actual = logString;
        assertEquals(expected, actual);
    }

    public void render() {
        logString += "render ";
    }

    public void run() {
        logString += "run ";
    }

}
