package InputGeneration.ValidatingInputGenerator.AlertingInputGenerator;

import InputGeneration.CountingGeneratorStub;
import InputGeneration.Input.Input;
import InputGeneration.ValidatingInputGenerator.InputValidatorStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidatingGeneratedInputTest {

    private InputValidatorStub validator = new InputValidatorStub();
    private CountingGeneratorStub generator = new CountingGeneratorStub();
    private InputAlerterDummy alerter = new InputAlerterDummy();
    private AlertingInputGenerator sut = new AlertingInputGenerator(generator, validator, alerter);

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

    private void makeFirstInputIsValid() {
        generatedInputs = new Input[] { new Input(0, 1) };

        generator.setGeneratedInputs(generatedInputs);
        validator.setValidInputs(generatedInputs);
    }

    private void makeOnlySecondInputIsValid() {
        generatedInputs = new Input[] { new Input(0, 1),
                new Input(1, 2) };

        Input[] validInputs = { generatedInputs[1] };

        generator.setGeneratedInputs(generatedInputs);
        validator.setValidInputs(validInputs);
    }

    private void makeOnlyThirdInputIsValid() {
        generatedInputs = new Input[] { new Input(0, 1),
                new Input(1, 2),
                new Input(2, 3) };

        Input[] validInputs = { generatedInputs[2] };

        generator.setGeneratedInputs(generatedInputs);
        validator.setValidInputs(validInputs);
    }

}
