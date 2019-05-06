package SequentialGaming.DelegatingGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DelegatingGameTest {

    private TurnSpy turn = new TurnSpy();
    private RendererSpy renderer = new RendererSpy();
    private GameOverRuleStub rule = new GameOverRuleStub();
    private DelegatingGame sut = new DelegatingGame(rule, renderer, turn);

    @Test
    void IfGameOverRuleIsOver_ShouldBeOverToo() {
        rule.setIsGameOver(true);

        assertIsOver();
    }

    @Test
    void IfGameOverRuleIsNotOver_ShouldNotBeOverToo() {
        rule.setIsGameOver(false);

        assertIsNotOver();
    }

    @Test
    void IfGetsPlayed_ShouldHavePlayedTheTurn() {
        sut.play();

        assertHasPlayed();
    }

    @Test
    void IfGetsRendered_ShouldHaveRenderedTheRenderer() {
        sut.render();

        assertHasRendered();
    }


    private void assertIsOver() {
        boolean actual = sut.isOver();
        assertTrue(actual);
    }

    private void assertIsNotOver() {
        boolean actual = sut.isOver();
        assertFalse(actual);
    }

    private void assertHasPlayed() {
        boolean actual = turn.hasPlayed();
        assertTrue(actual);
    }

    private void assertHasRendered() {
        boolean actual = renderer.hasRendered();
        assertTrue(actual);
    }

}
