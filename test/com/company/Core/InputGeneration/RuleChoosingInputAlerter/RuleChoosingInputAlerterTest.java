package com.company.Core.InputGeneration.RuleChoosingInputAlerter;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputRefereeImp.InputAlerter;
import com.company.Core.InputGeneration.InputRefereeImp.InputAlerterDummy;
import com.company.Core.InputGeneration.InputRule.InputRuleStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RuleChoosingInputAlerterTest {

    private RuleChoosingInputAlerter sut = new RuleChoosingInputAlerter();
    private InputAlerterMock mock = new InputAlerterMock();

    private Input input = new Input(0, 1);

    @Test
    void IfFirstRuleIsInvalidating_TheFirstAlerterShouldAlert() {
        makeMockIsRegisteredWithInvalidatingRule();
        mock.expectAlertedInput(input);

        sut.alert(input);

        mock.verifyAll();
    }

    @Test
    void IfFirstRuleIsValidating_TheFirstAlerterShouldNotAlert() {
        makeMockIsRegisteredWithValidatingRule();
        mock.expectHasNotAlerted();

        sut.alert(input);

        mock.verifyAll();
    }

    @Test
    void IfFirstRuleIsInvalidatingAndSecondIsValidating_TheFirstAlerterShouldAlert() {
        makeMockIsRegisteredWithInvalidatingRule();
        makeDummyIsRegisteredWithInvalidatingRule();
        mock.expectAlertedInput(input);

        sut.alert(input);

        mock.verifyAll();
    }

    @Test
    void IfFirstRuleIsValidatingAndSecondIsInvalidating_TheSecondAlerterShouldAlert() {
        makeDummyIsRegisteredWithInvalidatingRule();
        makeMockIsRegisteredWithInvalidatingRule();
        mock.expectAlertedInput(input);

        sut.alert(input);

        mock.verifyAll();
    }

    @Test
    void IfThirdAndSecondRulesAreInvalidatingAndFirstIsValidating_TheSecondAlerterShouldAlert() {
        makeDummyIsRegisteredWithValidatingRule();
        makeMockIsRegisteredWithInvalidatingRule();
        makeDummyIsRegisteredWithInvalidatingRule();
        mock.expectAlertedInput(input);

        sut.alert(input);

        mock.verifyAll();
    }

    private void makeMockIsRegisteredWithInvalidatingRule() {
        InputRuleStub rule = makeInvalidatingRule();
        sut.register(rule, mock);
    }

    private void makeMockIsRegisteredWithValidatingRule() {
        InputRuleStub rule = makeValidatingRule();
        sut.register(rule, mock);
    }

    private void makeDummyIsRegisteredWithInvalidatingRule() {
        InputRuleStub rule = makeInvalidatingRule();
        InputAlerterDummy dummy = new InputAlerterDummy();
        sut.register(rule, dummy);
    }

    private void makeDummyIsRegisteredWithValidatingRule() {
        InputRuleStub rule = makeValidatingRule();
        InputAlerterDummy dummy = new InputAlerterDummy();
        sut.register(rule, dummy);
    }

    private InputRuleStub makeInvalidatingRule() {
        InputRuleStub rule = new InputRuleStub();
        Input[] valids = {};
        rule.setValidInputs(valids);
        return rule;
    }

    private InputRuleStub makeValidatingRule() {
        InputRuleStub rule = new InputRuleStub();
        Input[] valids = {input};
        rule.setValidInputs(valids);
        return rule;
    }

    private class InputAlerterMock implements InputAlerter {

        private boolean expectedHasAlerted = false;
        private boolean actualHasAlerted = false;
        private Input expectedAlertedInput;
        private Input actualAlertedInput;

        public void verifyAll() {
            assertEquals(expectedHasAlerted, actualHasAlerted);
            assertEquals(expectedAlertedInput, actualAlertedInput);
        }

        public void expectAlertedInput(Input input) {
            this.expectedHasAlerted = true;
            this.expectedAlertedInput = input;
        }

        public void alert(Input input) {
            actualHasAlerted = true;
            actualAlertedInput = input;
        }

        public void expectHasNotAlerted() {
            expectedHasAlerted = false;
        }
    }


}
