package com.company.Core.InputGeneration.AlertingValidator;

import com.company.Core.InputGeneration.Input;
import com.company.Core.InputGeneration.InputValidatorStub;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlertingValidatorTest {

    private InputValidatorStub validator = new InputValidatorStub();
    private AlerterSpy alerter = new AlerterSpy();

    private AlertingValidator sut = new AlertingValidator(validator, alerter);

    Input input = new Input(1, 2);

    @Test
    void IfInputIsValid_ShouldReturnTrue() {
        makeInputValid(input);

        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

    @Test
    void IfInputIsInvalid_ShouldReturnFalse() {
        makeInputInvalid();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void IfInputIsInvalid_ShouldAlert() {
        makeInputInvalid();

        sut.isValid(input);

        assertHasAlerted();
    }


    private void assertHasAlerted() {
        boolean actual = alerter.hasAlerted();
        assertTrue(actual);
    }

    private void makeInputValid(Input input) {
        Input[] valid = { input };
        validator.setValidInputs(valid);
    }

    private void makeInputInvalid() {
        Input[] valid = {};
        validator.setValidInputs(valid);
    }
}

