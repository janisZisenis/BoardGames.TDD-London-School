package com.company.Core.InputGeneration.InputRefereeImp;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputRule.InputRuleDummy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputRefereeImpAlertingTest {

    private InputRuleDummy rule = new InputRuleDummy();
    private InputAlerterMock alerter = new InputAlerterMock();
    private InputRefereeImp sut = new InputRefereeImp(rule, alerter);

    private Input input = new Input(0, 1);

    @Test
    void IfInputGetsAlerted_TheInputAlerterShouldAlertTheInput() {
        alerter.expectAlertedInput(input);

        sut.alertIsInvalid(input);

        alerter.verifyAll();
    }

    private class InputAlerterMock implements InputAlerter {

        private boolean hasAlerted = false;
        private Input expectedAlertedInput;
        private Input actualAlertedInput;

        public void verifyAll() {
            assertTrue(hasAlerted);
            assertEquals(expectedAlertedInput, actualAlertedInput);
        }

        public void expectAlertedInput(Input input) {
            this.expectedAlertedInput = input;
        }

        public void alert(Input input) {
            hasAlerted = true;
            actualAlertedInput = input;
        }
    }

}
