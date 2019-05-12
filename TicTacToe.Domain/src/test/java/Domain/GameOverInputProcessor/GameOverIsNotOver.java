package Domain.GameOverInputProcessor;

import InputGeneration.Input.Input;
import InputGeneration.InputProcessorSpy;
import SequentialGaming.GameFacade.GameOverRuleStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverIsNotOver {

    private InputProcessorSpy processor = new InputProcessorSpy();
    private GameOverRuleStub rule = new GameOverRuleStub();
    private GameOverInputProcessor sut = new GameOverInputProcessor(processor, rule);

    @BeforeEach
    void SetUp() {
        rule.setIsGameOver(false);
    }

    @Test
    void IfInputIsR0C0_ShouldProcessInputWithR0C0() {
        Input input = new Input(0, 0);

        sut.process(input);

        assertProcessedInputEquals(new Input(0, 0));
    }

    @Test
    void IfInputIsR1C2_ShouldProcessInputWithR1C2() {
        Input input = new Input(1, 2);

        sut.process(input);

        assertProcessedInputEquals(new Input(1, 2));
    }

    private void assertProcessedInputEquals(Input expected) {
        Input actual = processor.getProcessed();
        assertEquals(expected, actual);
    }

}
