package Gaming.GameLoopImp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoopingUntilGameOverTest {

    private TurnSpy turn = new TurnSpy();
    private RendererSpy renderer = new RendererSpy();
    private CountingGameOverRuleStub rule = new CountingGameOverRuleStub();
    private GameLoopImp sut = new GameLoopImp(rule, turn, renderer);

    @Test
    void IfGameIsOverImmediately_ShouldHavePlay() {
        rule.setTimesNotGameOver(0);

        sut.run();

        assertHasPlayedTurnTimes(0);
    }

    @Test
    void IfGameIsOverImmediately_ShouldNotRender() {
        rule.setTimesNotGameOver(0);

        sut.run();

        assertHasRenderedTimes(0);
    }

    @Test
    void IfGameIsOverAfterOneTurn_ShouldPlayOnce() {
        rule.setTimesNotGameOver(1);

        sut.run();

        assertHasPlayedTurnTimes(1);
    }

    @Test
    void IfGameIsOverAfterOneTurn_ShouldRenderOnce() {
        rule.setTimesNotGameOver(1);

        sut.run();

        assertHasRenderedTimes(1);
    }

    @Test
    void IfGameIsOverAfterTwoTurns_ShouldPlayTwice() {
        rule.setTimesNotGameOver(2);

        sut.run();

        assertHasPlayedTurnTimes(2);
    }

    @Test
    void IfGameIsOverAfterTwoTurns_ShouldRenderTwice() {
        rule.setTimesNotGameOver(2);

        sut.run();

        assertHasRenderedTimes(2);
    }


    private void assertHasPlayedTurnTimes(int times) {
        int actual = turn.getPlayedTimes();
        int expected = times;
        assertEquals(expected, actual);
    }

    private void assertHasRenderedTimes(int times) {
        int actual = renderer.getTimesRendered();
        int expected = times;
        assertEquals(expected, actual);
    }

}
