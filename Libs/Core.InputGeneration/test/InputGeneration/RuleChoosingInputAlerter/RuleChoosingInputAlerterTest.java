package InputGeneration.RuleChoosingInputAlerter;

import InputGeneration.Input.Input;
import InputGeneration.InputValidatorImp.InputAlerterDummy;
import InputGeneration.InputValidatorImp.InputAlerterSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RuleChoosingInputAlerterTest {

    private RuleChoosingInputAlerter sut = new RuleChoosingInputAlerter();
    private InputAlerterSpy alerter = new InputAlerterSpy();

    private Input input = new Input(0, 1);

    @Test
    void IfFirstRuleIsInvalidating_TheFirstAlerterShouldAlert() {
        makeAlerterIsRegisteredWithInvalidatingRule();

        sut.alert(input);

        assertAlertedInputEquals(input);
    }

    @Test
    void IfFirstRuleIsValidating_TheFirstAlerterShouldNotAlert() {
        makeAlerterIsRegisteredWithValidatingRule();

        sut.alert(input);

        assertHasAlerted();
    }

    @Test
    void IfFirstRuleIsInvalidatingAndSecondIsValidating_TheFirstAlerterShouldAlert() {
        makeAlerterIsRegisteredWithInvalidatingRule();
        makeDummyIsRegisteredWithInvalidatingRule();

        sut.alert(input);

        assertAlertedInputEquals(input);
    }

    @Test
    void IfFirstRuleIsValidatingAndSecondIsInvalidating_TheSecondAlerterShouldAlert() {
        makeDummyIsRegisteredWithInvalidatingRule();
        makeAlerterIsRegisteredWithInvalidatingRule();

        sut.alert(input);

        assertAlertedInputEquals(input);
    }

    @Test
    void IfThirdAndSecondRulesAreInvalidatingAndFirstIsValidating_TheSecondAlerterShouldAlert() {
        makeDummyIsRegisteredWithValidatingRule();
        makeAlerterIsRegisteredWithInvalidatingRule();
        makeDummyIsRegisteredWithInvalidatingRule();

        sut.alert(input);

        assertAlertedInputEquals(input);
    }

    private void assertHasAlerted() {
        boolean actual = alerter.hasAlerted();
        assertFalse(actual);
    }

    private void assertAlertedInputEquals(Input expected) {
        Input actual = alerter.getAlerted();
        assertEquals(expected, actual);
    }

    private void makeAlerterIsRegisteredWithInvalidatingRule() {
        InputRuleStub rule = makeInvalidatingRule();
        sut.register(rule, alerter);
    }

    private void makeAlerterIsRegisteredWithValidatingRule() {
        InputRuleStub rule = makeValidatingRule();
        sut.register(rule, alerter);
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
