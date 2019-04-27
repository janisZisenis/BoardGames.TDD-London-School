package Lib.Model.GameLoopImp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoopingUntilGameOverTest {

    private CountingGameSpy game = new CountingGameSpy();
    private GameLoopImp sut = new GameLoopImp(game);

    @Test
    void IfGameIsOverAfterOneTurn_ShouldPlayOnce() {
        game.setTimesNotGameOver(1);

        sut.run();

        assertHasPlayedTurnTimes(1);
    }

    @Test
    void IfGameIsOverAfterOneTurn_ShouldRenderOnce() {
        game.setTimesNotGameOver(1);

        sut.run();

        assertHasRenderedTimes(1);
    }

    @Test
    void IfGameIsOverImmediately_ShouldHavePlay() {
        game.setTimesNotGameOver(0);

        sut.run();

        assertHasPlayedTurnTimes(0);
    }

    @Test
    void IfGameIsOverImmediately_ShouldNotRender() {
        game.setTimesNotGameOver(0);

        sut.run();

        assertHasRenderedTimes(0);
    }

    @Test
    void IfGameIsOverAfterTwoTurns_ShouldPlayTwice() {
        game.setTimesNotGameOver(2);

        sut.run();

        assertHasPlayedTurnTimes(2);
    }

    @Test
    void IfGameIsOverAfterOneTurn_ShouldRenderTwice() {
        game.setTimesNotGameOver(2);

        sut.run();

        assertHasRenderedTimes(2);
    }

    private void assertHasPlayedTurnTimes(int times) {
        int actual = game.getTimesPlayedTurn();
        int expected = times;
        assertEquals(expected, actual);
    }

    private void assertHasRenderedTimes(int times) {
        int actual = game.getTimesRendered();
        int expected = times;
        assertEquals(expected, actual);
    }

}
