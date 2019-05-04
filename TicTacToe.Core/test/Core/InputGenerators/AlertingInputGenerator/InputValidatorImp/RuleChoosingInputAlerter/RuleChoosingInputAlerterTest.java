package Core.InputGenerators.AlertingInputGenerator.InputValidatorImp.RuleChoosingInputAlerter;

import Core.Input.Input;
import Core.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputAlerterDummy;
import Core.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputAlerterMock;
import org.junit.jupiter.api.Test;

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

}
