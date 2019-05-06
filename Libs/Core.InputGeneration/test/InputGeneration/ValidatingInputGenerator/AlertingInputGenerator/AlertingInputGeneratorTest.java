package InputGeneration.ValidatingInputGenerator.AlertingInputGenerator;

import InputGeneration.CountingGeneratorStub;
import InputGeneration.Input.Input;
import InputGeneration.ValidatingInputGenerator.InputValidatorStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AlertingInputGeneratorTest {

    private CountingGeneratorStub generator = new CountingGeneratorStub();
    private InputValidatorStub validator = new InputValidatorStub();
    private InputAlerterSpy alerter = new InputAlerterSpy();
    private AlertingInputGenerator sut = new AlertingInputGenerator(generator, validator, alerter);

    private Input[] generatedInputs;

    @Test
    void IfFirstInputIsValid_ShouldNotAlert() {
        makeFirstInputIsValid();

        sut.generate();

        assertHasNotAlerted();
    }

    @Test
    void IfOnlySecondInputIsValid_ShouldAlertTheFirst() {
        makeOnlySecondInputIsValid();

        sut.generate();

        assertAlertedInputEquals(generatedInputs[0]);
    }

    @Test
    void IfOnlyThirdInputIsValid_ShouldAlertTheSecond() {
        makeOnlyThirdInputIsValid();

        sut.generate();

        assertAlertedInputEquals(generatedInputs[1]);
    }

    private void assertAlertedInputEquals(Input expected) {
        Input actual = alerter.getAlerted();
        assertEquals(expected, actual);
    }

    private void assertHasNotAlerted() {
        boolean actual = alerter.hasAlerted();
        assertFalse(actual);
    }


    private void makeFirstInputIsValid() {
        generatedInputs = new Input[] { new Input(0, 0) };

        generator.setGeneratedInputs(generatedInputs);
        validator.setValidInputs(generatedInputs);
    }

    private void makeOnlySecondInputIsValid() {
        generatedInputs = new Input[] { new Input(0, 0),
                                        new Input(2, 1) };

        Input[] validInputs = { generatedInputs[1] };

        generator.setGeneratedInputs(generatedInputs);
        validator.setValidInputs(validInputs);
    }

    private void makeOnlyThirdInputIsValid() {
        generatedInputs = new Input[] { new Input(0, 0),
                                        new Input(2, 1),
                                        new Input(1, 0) };

        Input[] validInputs = { generatedInputs[2] };

        generator.setGeneratedInputs(generatedInputs);
        validator.setValidInputs(validInputs);
    }



}
