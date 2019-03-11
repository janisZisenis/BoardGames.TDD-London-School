package com.company.Core.Rules.AlertingRule;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputRuleStub;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlertingRuleTest {

    private InputRuleStub rule = new InputRuleStub();
    private AlerterSpy alerter = new AlerterSpy();

    private AlertingRule sut = new AlertingRule(rule, alerter);

    private Input input = new Input(1, 2);

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
        rule.setValidInputs(valid);
    }

    private void makeInputInvalid() {
        Input[] valid = {};
        rule.setValidInputs(valid);
    }
}

