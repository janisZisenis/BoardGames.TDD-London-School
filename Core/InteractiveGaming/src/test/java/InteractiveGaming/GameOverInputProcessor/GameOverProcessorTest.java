package InteractiveGaming.GameOverInputProcessor;

import Gaming.GameFacade.GameOverRuleStub;
import Input2D.Input.Input;
import Input2D.InputProcessorSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class GameOverProcessorTest {

    private InputProcessorSpy processor = new InputProcessorSpy();
    private GameOverRuleStub rule = new GameOverRuleStub();
    private GameOverInputProcessor sut = new GameOverInputProcessor(processor, rule);

    @Test
    void IfGameIsNotOver_ShouldProcessInput() {
        Input input = new Input(0, 0);
        rule.setIsGameOver(false);

        sut.process(input);

        assertProcessedInputEquals(input);
    }

    private void assertProcessedInputEquals(Input expected) {
        Input actual = processor.getProcessed();
        assertEquals(expected, actual);
    }


    @Test
    void IfGameIsOver_ShouldNotProcessTheInput() {
        Input input = new Input(0, 0);
        rule.setIsGameOver(true);

        sut.process(input);

        assertHasNotProcessedInput();
    }

    private void assertHasNotProcessedInput() {
        boolean actual = processor.hasProcessed();
        assertFalse(actual);
    }
}
