package com.company.Core.InputGeneration.AlertingValidator;

import com.company.Core.InputGeneration.Input;
import com.company.Core.InputGeneration.InputValidatorStub;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlertingValidatorTest {

    InputValidatorStub validator = new InputValidatorStub();
    AlerterSpy alerter = new AlerterSpy();

    AlertingValidator sut = new AlertingValidator(validator, alerter);

    Input input = new Input(1, 2);

    @Test
    void IfInputIsValid_ShouldReturnTrue() {
        Input[] valid = { new Input(1, 2) };
        validator.setValidInputs(valid);

        boolean actual = sut.isValid(input);
        assertTrue(actual);
    }

    @Test
    void IfInputIsInvalid_ShouldReturnFalse() {
        Input[] valid = {};
        validator.setValidInputs(valid);

        boolean actual = sut.isValid(input);
        assertFalse(actual);
    }

    @Test
    void IfInputIsInvalid_ShouldAlert() {
        Input[] valid = {};
        validator.setValidInputs(valid);

        sut.isValid(input);

        assertHasAlerted();
    }

    private void assertHasAlerted() {
        boolean actual = alerter.hasAlerted();
        assertTrue(actual);
    }
}
