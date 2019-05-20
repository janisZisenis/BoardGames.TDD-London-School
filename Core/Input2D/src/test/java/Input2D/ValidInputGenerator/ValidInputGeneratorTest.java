package Input2D.ValidInputGenerator;

import Input2D.CountingGeneratorStub;
import Input2D.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class ValidInputGeneratorTest {

    private CountingGeneratorStub generator = new CountingGeneratorStub();
    private InputValidatorStub validator = new InputValidatorStub();
    private InputAlerterSpy alerter = new InputAlerterSpy();
    private ValidInputGenerator sut = new ValidInputGenerator(generator, validator, alerter);

    private Input[] generatedInputs;

    @Test
    void IfFirstInputIsValid_ShouldBeTheFirstInput() {
        makeFirstInputIsValid();

        Input actual = sut.generate();

        Input expected = generatedInputs[0];
        assertEquals(expected, actual);
    }

    @Test
    void IfOnlySecondInputIsValid_ShouldBeTheSecondInput() {
        makeOnlySecondInputIsValid();

        Input actual = sut.generate();

        Input expected = generatedInputs[1];
        assertEquals(expected, actual);
    }

    @Test
    void IfOnlyThirdInputIsValid_ShouldBeTheThirdInput() {
        makeOnlyThirdInputIsValid();

        Input actual = sut.generate();

        Input expected = generatedInputs[2];
        assertEquals(expected, actual);
    }


    @Test
    void IfFirstInputIsValid_ShouldNotAlert() {
        makeFirstInputIsValid();

        sut.generate();

        assertHasNotAlerted();
    }

    private void assertHasNotAlerted() {
        boolean actual = alerter.hasAlerted();
        assertFalse(actual);
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
