package GuiGaming.TicTacToeFacade;

import Domain.GameEvaluation.EquallyMarkedLineEvaluator.MarkedFieldProviderDummy;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProviderDummy;
import InputGeneration.Input.Input;
import InputGeneration.InputProcessorSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcessingTheInputTest {

    private WinningLineProviderDummy provider = new WinningLineProviderDummy();
    private InputProcessorSpy processor = new InputProcessorSpy();
    private MarkedFieldProviderDummy markedFieldProvider = new MarkedFieldProviderDummy();
    private TicTacToeFacade sut = new TicTacToeFacade(provider, processor, markedFieldProvider);

    @Test
    void IfInputR0C0IsProcessed_ShouldProcessInputR0C0Either() {
        Input input = new Input(0, 0);

        sut.process(input);

        assertProcessedInputEquals(new Input(0, 0));
    }

    @Test
    void IfInputR2C1IsProcessed_ShouldProcessInputR2C1Either() {
        Input input = new Input(2, 1);

        sut.process(input);

        assertProcessedInputEquals(new Input(2, 1));
    }

    private void assertProcessedInputEquals(Input expected) {
        Input actual = processor.getProcessed();
        assertEquals(expected, actual);
    }

}
