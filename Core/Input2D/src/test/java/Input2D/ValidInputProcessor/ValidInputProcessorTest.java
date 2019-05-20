package Input2D.ValidInputProcessor;

import Input2D.Input.Input;
import Input2D.InputProcessorSpy;
import Input2D.ValidInputGenerator.InputAlerterSpy;
import Input2D.ValidInputGenerator.InputValidatorStub;
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

    private void assertHasNotProcessed() {
        boolean actual = processor.hasProcessed();
        assertFalse(actual);
    }


    @Test
    void IfInputIsInvalid_ShouldNotProcessTheInput() {
        sut.process(input);

        assertHasNotProcessed();
    }

    private void assertProcessedInputEquals(Input expected) {
        Input actual = processor.getProcessed();
        assertEquals(expected, actual);
    }


    @Test
    void IfInputIsInvalid_ShouldAlert() {
        sut.process(input);

        assertAlertedInputEquals(input);
    }

    private void assertAlertedInputEquals(Input expected) {
        Input actual = alerter.getAlerted();
        assertEquals(expected, actual);
    }


    @Test
    void IfInputIsValid_ShouldNotAlert() {
        makeInputIsValid(input);

        sut.process(input);

        assertHasNotAlerted();
    }

    private void assertHasNotAlerted() {
        boolean actual = alerter.hasAlerted();
        assertFalse(actual);
    }



    private void makeInputIsValid(Input input) {
        validator.setValidInputs(new Input[]{input});
    }

}
