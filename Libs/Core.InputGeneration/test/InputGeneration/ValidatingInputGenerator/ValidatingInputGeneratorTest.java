package InputGeneration.ValidatingInputGenerator;

import InputGeneration.CountingGeneratorStub;
import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatingInputGeneratorTest {

    private CountingGeneratorStub generator = new CountingGeneratorStub();
    private InputValidatorStub validator = new InputValidatorStub();
    private ValidatingInputGenerator sut = new ValidatingInputGenerator(generator, validator);

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