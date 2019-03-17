package com.company.Core.InputGeneration.VerboseValidatingInputGenerator.InputRefereeImp;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputRule.InputRuleDummy;
import org.junit.jupiter.api.Test;

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

}
