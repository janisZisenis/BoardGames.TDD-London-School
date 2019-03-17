package com.company.Core.InputGeneration.InputRefereeImp;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputRule.InputRuleStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputRefereeImpValidatingTest {

    private InputRuleStub rule = new InputRuleStub();
    private InputAlerterDummy alerter = new InputAlerterDummy();
    private InputRefereeImp sut = new InputRefereeImp(rule, alerter);

    private Input input = new Input(0, 1);

    @Test
    void IfRuleValidatesInput_ItShouldBeValid() {
        makeInputIsValid();

        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

    @Test
    void IfRuleInvalidatesInput_ItShouldBeInvalid() {
        makeInputIsInvalid();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    private void makeInputIsValid() {
        Input[] valids = new Input[] { input };
        rule.setValidInputs(valids);
    }

    private void makeInputIsInvalid() {
        Input[] valids = new Input[] {};
        rule.setValidInputs(valids);
    }

}
