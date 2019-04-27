package Lib.Model.RenderingGameLoop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayingBeforeRenderingTest {

    CountingGameSpy game = new CountingGameSpy();
    RenderingGameLoop sut = new RenderingGameLoop(game);

    @Test
    void IfGameIsOverAfterOneTurn_ShouldPlayATurnBeforeRendering() {
        game.setTimesNotGameOver(1);

        sut.run();

        assertLogStringIs("playTurn render ");
    }

    private void assertLogStringIs(String logString) {
        String actual = game.getLogString();
        String expected = logString;
        assertEquals(expected, actual);
    }
}
