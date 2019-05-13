package GuiGaming.HybridGameFacade;

import InputGeneration.Input.Input;
import SequentialGaming.GameFacade.GameOverRuleStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HybridGameFacadeTest {

    private GameOverRuleStub rule = new GameOverRuleStub();
    private HybridPlayerSpy player = new HybridPlayerSpy();
    private HybridGameFacade sut = new HybridGameFacade(rule, player);

    @Test
    void IfGameOverRuleIsOver_ShouldBeOverEither() {
        rule.setIsGameOver(true);

        assertIsOver();
    }

    private void assertIsOver() {
        boolean actual = sut.isOver();
        assertTrue(actual);
    }


    @Test
    void IfGameOverRuleIsNotOver_ShouldNotBeOverEither() {
        rule.setIsGameOver(false);

        assertIsNotOver();
    }

    private void assertIsNotOver() {
        boolean actual = sut.isOver();
        assertFalse(actual);
    }


    @Test
    void IfHybridPlayerNeedsInput_ShouldNeedInputEither() {
        player.setNeedsInput(true);

        assertShouldNeedInput();
    }

    private void assertShouldNeedInput() {
        boolean actual = sut.needsInput();
        assertTrue(actual);
    }


    @Test
    void IfHybridPlayerDoesNotNeedInput_ShouldNotNeedInputEither() {
        player.setNeedsInput(false);

        assertShouldDoesNotNeedInput();
    }

    private void assertShouldDoesNotNeedInput() {
        boolean actual = sut.needsInput();
        assertFalse(actual);
    }

    @Test
    void IfGetsPlayedWithoutInput_ShouldPlayWithoutInputEither() {
        sut.play();

        assertHasPlayedTimes(1);
    }

    private void assertHasPlayedTimes(int expected) {
        int actual = player.getPlayedTimes();
        assertEquals(expected, actual);
    }


    @Test
    void IfGetsPlayedWithInputR0C0_ShouldPlayInputR0C0Either() {
        Input input = new Input(0, 0);

        sut.play(input);

        assertPlayedInputEquals(new Input(0, 0));
    }

    @Test
    void IfGetsPlayedWithInputR1C2_ShouldPlayInputR1C2Either() {
        Input input = new Input(1, 2);

        sut.play(input);

        assertPlayedInputEquals(new Input(1, 2));
    }

    private void assertPlayedInputEquals(Input expected) {
        Input actual = player.getPlayedInput();
        assertEquals(expected, actual);
    }

}
