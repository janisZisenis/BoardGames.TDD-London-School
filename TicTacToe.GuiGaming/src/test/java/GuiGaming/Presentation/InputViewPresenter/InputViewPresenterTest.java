package GuiGaming.Presentation.InputViewPresenter;

import InputGeneration.Input.Input;
import InputGeneration.InputProcessorSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputViewPresenterTest {

    private InputProcessorSpy processor = new InputProcessorSpy();
    private InputViewPresenter sut = new InputViewPresenter(processor);

    @Test
    void IfR0C0IsGenerated_ShouldProcessInputWithR0C0() {
        int row = 0;
        int col = 0;

        sut.onInputGenerated(row, col);

        assertProcessedInputEquals(new Input(0, 0));
    }

    @Test
    void IfR1C2IsGenerated_ShouldProcessInputWithR1C2() {
        int row = 1;
        int col = 2;

        sut.onInputGenerated(row, col);

        assertProcessedInputEquals(new Input(1, 2));
    }

    private void assertProcessedInputEquals(Input expected) {
        Input actual = processor.getProcessed();
        assertEquals(expected, actual);
    }
}
