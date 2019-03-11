package com.company.Core.InputGeneration.CompositeValidator;

import com.company.Core.Rules.AlertingRule.AlerterSpy;
import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputRuleStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CompositeValidatorTest {

    private CompositeValidator sut = new CompositeValidator();
    private Input input = new Input(0 ,1);

    @Test
    void FreshInstance_InputShouldBeValid() {
        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

    @Test
    void RegisteredInvalidator_InputShouldBeInvalid() {
        makeInvalidatingRuleAlerterPairRegistered();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void RegisteredValidator_InputShouldBeValid() {
        makeValidatingRuleAlerterPairRegistered();

        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

    @Test
    void RegisteredValidatorAfterInvalidator_InputShouldBeInvalid() {
        makeInvalidatingRuleAlerterPairRegistered();
        makeValidatingRuleAlerterPairRegistered();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void RegisteredInvalidatorAfterValidator_InputShouldBeInvalid() {
         makeValidatingRuleAlerterPairRegistered();
         makeInvalidatingRuleAlerterPairRegistered();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void RegisteredTwoValidators_InputShouldBeValid() {
        makeValidatingRuleAlerterPairRegistered();
        makeValidatingRuleAlerterPairRegistered();

        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

    private void makeValidatingRuleAlerterPairRegistered() {
        InputRuleStub rule = makeValidatingRule();

        AlerterDummy alerter = new AlerterDummy();
        sut.register(rule, alerter);
    }

    private void makeInvalidatingRuleAlerterPairRegistered() {
        InputRuleStub rule = makeInvalidatingRule();

        AlerterDummy alerter = new AlerterDummy();
        sut.register(rule, alerter);
    }

    private InputRuleStub makeValidatingRule() {
        InputRuleStub rule = new InputRuleStub();
        Input[] valid = { input };
        rule.setValidInputs(valid);
        return rule;
    }

    private InputRuleStub makeInvalidatingRule() {
        InputRuleStub rule = new InputRuleStub();
        Input[] valid = {};
        rule.setValidInputs(valid);
        return rule;
    }

}
