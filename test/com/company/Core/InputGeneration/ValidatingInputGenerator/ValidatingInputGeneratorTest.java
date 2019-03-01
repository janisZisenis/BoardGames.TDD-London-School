package com.company.Core.InputGeneration.ValidatingInputGenerator;

import com.company.Core.InputGeneration.CountingValidatorStub;
import com.company.Core.InputGeneration.CountingGeneratorStub;
import com.company.Core.InputGeneration.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatingInputGeneratorTest {

    private CountingGeneratorStub generator = new CountingGeneratorStub();
    private CountingValidatorStub validator = new CountingValidatorStub();
    private ValidatingInputGenerator sut = new ValidatingInputGenerator(generator, validator);

    private Input[] inputs;

    @Test
    void IfFirstUserInputIsValid_ShouldBeTheFirstUserInput() {
        makeFirstUserInputIsValid();

        Input actual = sut.generateInput();

        Input expected = inputs[0];
        assertEquals(expected, actual);
    }

    @Test
    void IfFirstUserInputIsNotValid_ShouldBeTheSecondUserInput() {
        makeFirstInputIsNotValid();

        Input actual = sut.generateInput();

        Input expected = inputs[1];
        assertEquals(expected, actual);
    }

    @Test
    void IfFirstAndSecondUserInputIsNotValid_ShouldBeTheThirdUserInput() {
        makeFirstAndSecondInputIsNotValid();

        Input actual = sut.generateInput();

        Input expected = inputs[2];
        assertEquals(expected, actual);
    }

    private void makeFirstUserInputIsValid() {
        validator.setTimesUserInputIsInvalid(0);

        inputs = new Input[] { new Input(0, 1) };
        generator.setUserInputs(inputs);
    }

    private void makeFirstInputIsNotValid() {
        validator.setTimesUserInputIsInvalid(1);

        inputs = new Input[]{ new Input(0, 1),
                              new Input(1, 2) };
        generator.setUserInputs(inputs);
    }

    private void makeFirstAndSecondInputIsNotValid() {
        validator.setTimesUserInputIsInvalid(2);

        inputs = new Input[]{ new Input(0, 1),
                              new Input(1, 2),
                              new Input(2, 3) };
        generator.setUserInputs(inputs);
    }


}