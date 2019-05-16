package Gaming.GameFacade;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameFacadeTest {

    private PlayerSpy player = new PlayerSpy();
    private RendererSpy renderer = new RendererSpy();
    private GameOverRuleStub rule = new GameOverRuleStub();
    private GameFacade sut = new GameFacade(rule, renderer, player);

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
    void IfGetsPlayed_ShouldHavePlayedTheVerbosePlayer() {
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
        boolean actual = player.hasPlayed();
        assertTrue(actual);
    }

    private void assertHasRendered() {
        boolean actual = renderer.hasRendered();
        assertTrue(actual);
    }

}
