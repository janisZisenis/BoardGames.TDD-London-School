package com.company.Core.InputGeneration.AlertingValidator;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputRuleStub;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlertingValidatorTest {

    private InputRuleStub validator = new InputRuleStub();
    private AlerterSpy alerter = new AlerterSpy();

    private AlertingRule sut = new AlertingRule(validator, alerter);

    private Input input = new Input(1, 2);

    @Test
    void IfInputIsValid_ShouldReturnTrue() {
        makeInputValid(input);

        boolean actual = sut.validates(input);

        assertTrue(actual);
    }

    @Test
    void IfInputIsInvalid_ShouldReturnFalse() {
        makeInputInvalid();

        boolean actual = sut.validates(input);

        assertFalse(actual);
    }

    @Test
    void IfInputIsInvalid_ShouldAlert() {
        makeInputInvalid();

        sut.validates(input);

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

