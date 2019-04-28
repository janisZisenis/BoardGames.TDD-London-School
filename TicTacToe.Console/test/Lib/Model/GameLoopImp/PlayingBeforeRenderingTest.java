package Lib.Model.GameLoopImp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayingBeforeRenderingTest {

    private CountingGameSpy game = new CountingGameSpy();
    private GameLoopImp sut = new GameLoopImp(game);

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
