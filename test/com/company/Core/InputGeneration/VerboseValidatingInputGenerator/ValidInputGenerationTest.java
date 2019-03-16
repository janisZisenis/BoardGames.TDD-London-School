package com.company.Core.InputGeneration.VerboseValidatingInputGenerator;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.ValidatingInputGenerator.CountingGeneratorStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidInputGenerationTest {

    private InputValidatorStub validator = new InputValidatorStub();
    private CountingGeneratorStub generator = new CountingGeneratorStub();
    private VerboseValidatingInputGenerator sut = new VerboseValidatingInputGenerator(generator, validator);

    private Input[] generated;
    private Input[] valids;

    @Test
    void IfValidatorValidatesFirstInput_ItShouldBeTheFirst() {
        makeFirstGeneratedInputIsValid();

        Input actual = sut.generate();

        Input expected = generated[0];
        assertEquals(expected, actual);
    }

    @Test
    void IfValidatorInvalidatesFirstInput_ItShouldBeTheSecond() {
        makeSecondGeneratedInputIsValid();

        Input actual = sut.generate();

        Input expected = generated[1];
        assertEquals(expected, actual);
    }

    @Test
    void IfValidatorInvalidatesFirstAndSecondInput_ItShouldBeTheThird() {
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
