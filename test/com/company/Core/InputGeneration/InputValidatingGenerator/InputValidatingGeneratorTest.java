package com.company.Core.InputGeneration.InputValidatingGenerator;

import com.company.Core.InputGeneration.CountingGeneratorStub;
import com.company.Core.InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputValidatingGeneratorTest {

    private CountingGeneratorStub generator = new CountingGeneratorStub();
    private CountingInputValidatorSpy validator = new CountingInputValidatorSpy();
    private InputValidatingGenerator sut = new InputValidatingGenerator(generator, validator);

    private Input[] generated;

    @Test
    void IfFirstUserInputIsValid_ShouldBeTheFirstUserInput() {
        makeFirstUserInputIsValid();

        Input actual = sut.generate();

        assertIsFirstInput(actual);
    }

    @Test
    void IfFirstUserInputIsNotValid_ShouldBeTheSecondUserInput() {
        makeFirstInputIsNotValid();

        Input actual = sut.generate();

        assertIsSecondInput(actual);
    }

    @Test
    void IfFirstUserInputIsNotValid_ShouldHaveAlertedOnce() {
        makeFirstInputIsNotValid();

        sut.generate();

        assertTimesAlerted(1);
    }

    @Test
    void IfFirstUserInputIsValid_ShouldNotHaveAlerted() {
        makeFirstUserInputIsValid();

        sut.generate();

        assertTimesAlerted(0);
    }

    @Test
    void IfFirstAndSecondUserInputIsNotValid_ShouldBeTheThirdUserInput() {
        makeFirstAndSecondInputIsNotValid();

        Input actual = sut.generate();

        assertIsThirdInput(actual);
    }

    @Test
    void IfFirstAndSecondUserInputIsNotValid_ShouldHaveAlertedTwice() {
        makeFirstAndSecondInputIsNotValid();

        sut.generate();

        assertTimesAlerted(2);
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

    private void assertTimesAlerted(int i) {
        int actual = validator.getTimesAlerted();
        int expected = i;
        assertEquals(expected, actual);
    }

    private void assertIsFirstInput(Input actual) {
        Input expected = generated[0];
        assertEquals(expected, actual);
    }

    private void assertIsSecondInput(Input actual) {
        Input expected = generated[1];
        assertEquals(expected, actual);
    }

    private void assertIsThirdInput(Input actual) {
        Input expected = generated[2];
        assertEquals(expected, actual);
    }
}
