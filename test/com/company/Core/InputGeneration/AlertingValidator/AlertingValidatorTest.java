package com.company.Core.InputGeneration.AlertingValidator;

import com.company.Core.InputGeneration.Input;
import com.company.Core.InputGeneration.ValidatorStub;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlertingValidatorTest {

    ValidatorStub validator = new ValidatorStub();
    AlerterSpy alerter = new AlerterSpy();
    String message = "MessageToBeAlerted";

    AlertingValidator sut = new AlertingValidator(validator, alerter, message);

    Input input = new Input(1, 2);

    @Test
    void IfInputIsValid_ShouldReturnTrue() {
        validator.setInputIsValid();

        boolean actual = sut.isValid(input);
        assertTrue(actual);
    }

    @Test
    void IfInputIsInvalid_ShouldReturnFalse() {
        validator.setInputIsInvalid();

        boolean actual = sut.isValid(input);
        assertFalse(actual);
    }

    @Test
    void IfInputIsInvalid_ShouldAlert() {
        validator.setInputIsInvalid();

        sut.isValid(input);

        assertHasAlerted(message);
    }

    private void assertHasAlerted(String expected) {
        String actual = alerter.getAlertedMessage();
        assertEquals(expected, actual);
    }
}
