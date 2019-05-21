package InteractiveGaming.InputProcessors.InputTurnProcessor;

import Input2D.Input.Input;
import Input2D.InputProcessorSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class InputTurnProcessorTest {

    private IsInputTurnProviderStub provider = new IsInputTurnProviderStub();
    private InputProcessorSpy processor = new InputProcessorSpy();
    private InputTurnProcessor sut = new InputTurnProcessor(processor, provider);

    private Input input = new Input(0, 0);

    @Test
    void IfIsInputTurn_ShouldProcessInput() {
        provider.setIsInputTurn(true);

        sut.process(input);

        assertProcessedInputEquals(input);
    }

    private void assertProcessedInputEquals(Input expected) {
        Input actual = processor.getProcessed();
        assertEquals(expected, actual);
    }

    @Test
    void IfIsNotInputTurn_ShouldNotProcess() {
        provider.setIsInputTurn(false);

        sut.process(input);

        assertHasNotProcessed();
    }

    private void assertHasNotProcessed() {
        boolean actual = processor.hasProcessed();
        assertFalse(actual);
    }

}
