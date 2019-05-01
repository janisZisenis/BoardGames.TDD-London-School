package Lib.InputGenerators.AlertingInputGenerator;

import Lib.Data.Input.Input;
import Lib.Players.CountingGeneratorStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatingGeneratedInputTest {

    private InputValidatorStub validator = new InputValidatorStub();
    private CountingGeneratorStub generator = new CountingGeneratorStub();
    private AlertingInputGenerator sut = new AlertingInputGenerator(generator, validator);

    private Input[] generated;
    private Input[] valids;

    @Test
    void IfFirstInputIsValid_ItShouldBeTheFirst() {
        makeFirstGeneratedInputIsValid();

        Input actual = sut.generate();

        Input expected = generated[0];
        assertEquals(expected, actual);
    }

    @Test
    void IfFirstInputIsInvalid_ItShouldBeTheSecond() {
        makeSecondGeneratedInputIsValid();

        Input actual = sut.generate();

        Input expected = generated[1];
        assertEquals(expected, actual);
    }

    @Test
    void IfFirstAndSecondInputAreInvalid_ItShouldBeTheThird() {
        makeThirdGeneratedInputIsValid();

        Input actual = sut.generate();

        Input expected = generated[2];
        assertEquals(expected, actual);
    }

    private void makeFirstGeneratedInputIsValid() {
        generated = new Input[] { new Input (0, 1) };
        generator.setGeneratedInputs(generated);

        valids = new Input[] { generated[0] };
        validator.setValidInputs(valids);
    }

    private void makeSecondGeneratedInputIsValid() {
        generated = new Input[] { new Input(0, 1),
                                  new Input(0, 2) };
        generator.setGeneratedInputs(generated);

        valids = new Input[] { generated[1] };
        validator.setValidInputs(valids);
    }

    private void makeThirdGeneratedInputIsValid() {
        generated = new Input[] { new Input(0, 1),
                                  new Input(0, 2),
                                  new Input(0, 0) };
        generator.setGeneratedInputs(generated);

        valids = new Input[] { generated[2] };
        validator.setValidInputs(valids);
    }

}
