package Lib.Model.RenderingGameLoop.GameImp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameImpTest {

    private TurnSpy turn = new TurnSpy();
    private GameOverRuleStub rule = new GameOverRuleStub();
    private RendererSpy renderer = new RendererSpy();
    private GameImp sut = new GameImp(turn, rule, renderer);

    @Test
    void IfGameGetsPlayed_ShouldPlayTheTurn() {
        sut.playTurn();

        boolean actual = turn.hasPlayed();
        assertTrue(actual);
    }

    @Test
    void IfGameGetsRendered_ShouldRenderTheGameOnRenderer() {
        sut.render();

        boolean actual = renderer.hasRendered();
        assertTrue(actual);
    }

    @Test
    void IfRuleIsGameOver_ShouldBeOverToo() {
        rule.setGameIsOver(true);

        assertIsOver();
    }

    @Test
    void IfRuleIsNotGameOver_ShouldNotBeOverToo() {
        rule.setGameIsOver(false);

        assertIsNotOver(sut);
    }


    private void assertIsOver() {
        boolean actual = sut.isOver();
        assertTrue(actual);
    }

    private void assertIsNotOver(GameImp sut) {
        boolean actual = sut.isOver();
        assertFalse(actual);
    }

}
