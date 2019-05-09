package InputGeneration.ValidInputProcessor;

import InputGeneration.Input.Input;
import InputGeneration.ValidInputGenerator.InputAlerterSpy;
import InputGeneration.ValidInputGenerator.InputValidatorStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidInputProcessorTest {

    private InputProcessorSpy processor = new InputProcessorSpy();
    private InputValidatorStub validator = new InputValidatorStub();
    private InputAlerterSpy alerter = new InputAlerterSpy();
    private ValidInputProcessor sut = new ValidInputProcessor(processor, validator, alerter);

    private Input input = new Input(0, 0);

    @Test
    void IfInputIsValid_ShouldProcessTheInput() {
        makeInputIsValid(input);

        sut.process(input);

        assertProcessedInputEquals(input);
    }

    @Test
    void IfInputIsInvalid_ShouldNotProcessTheInput() {
        sut.process(input);

        assertHasNotProcessed();
    }

    @Test
    void IfInputIsInvalid_ShouldAlert() {
        sut.process(input);

        assertAlertedInputEquals(input);
    }

    @Test
    void IfInputIsValid_ShouldNotAlert() {
        makeInputIsValid(input);

        sut.process(input);

        assertHasNotAlerted();
    }

    private void makeInputIsValid(Input input) {
        validator.setValidInputs(new Input[]{input});
    }

    private void assertProcessedInputEquals(Input expected) {
        Input actual = processor.getProcessed();
        assertEquals(expected, actual);
    }

    private void assertHasNotProcessed() {
        boolean actual = processor.hasProcessed();
        assertFalse(actual);
    }

    private void assertAlertedInputEquals(Input expected) {
        Input actual = alerter.getAlerted();
        assertEquals(expected, actual);
    }

    private void assertHasNotAlerted() {
        boolean actual = alerter.hasAlerted();
        assertFalse(actual);
    }

}
