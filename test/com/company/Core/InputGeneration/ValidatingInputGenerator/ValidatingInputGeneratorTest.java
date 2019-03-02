package com.company.Core.InputGeneration.ValidatingInputGenerator;

import com.company.Core.InputGeneration.CountingValidatorStub;
import com.company.Core.InputGeneration.CountingGeneratorStub;
import com.company.Core.InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatingInputGeneratorTest {

    private CountingGeneratorStub generator = new CountingGeneratorStub();
    private CountingValidatorStub validator = new CountingValidatorStub();
    private ValidatingInputGenerator sut = new ValidatingInputGenerator(generator, validator);

    private Input[] generated;

    @Test
    void IfFirstUserInputIsValid_ShouldBeTheFirstUserInput() {
        makeFirstUserInputIsValid();

        Input actual = sut.generateInput();

        Input expected = generated[0];
        assertEquals(expected, actual);
    }

    @Test
    void IfFirstUserInputIsNotValid_ShouldBeTheSecondUserInput() {
        makeFirstInputIsNotValid();

        Input actual = sut.generateInput();

        Input expected = generated[1];
        assertEquals(expected, actual);
    }

    @Test
    void IfFirstAndSecondUserInputIsNotValid_ShouldBeTheThirdUserInput() {
        makeFirstAndSecondInputIsNotValid();

        Input actual = sut.generateInput();

        Input expected = generated[2];
        assertEquals(expected, actual);
    }

    private void makeFirstUserInputIsValid() {
        generated = new Input[] { new Input(0, 1) };

        generator.setUserInputs(generated);
        validator.setValidInputs(generated);
    }

    private void makeFirstInputIsNotValid() {
        generated = new Input[] { new Input(0, 1),
                                  new Input(1, 2) };

        Input[] valid = { new Input(1, 2) };

        generator.setUserInputs(generated);
        validator.setValidInputs(valid);
    }

    private void makeFirstAndSecondInputIsNotValid() {
        generated = new Input[] { new Input(0, 1),
                                  new Input(1, 2),
                                  new Input(2, 3) };

        Input[] valid = { new Input(2, 3) };

        generator.setUserInputs(generated);
        validator.setValidInputs(valid);
    }


}