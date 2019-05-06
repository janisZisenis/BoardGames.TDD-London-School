package InputGeneration.InputValidatorImp;

import InputGeneration.Input.Input;
import InputGeneration.RuleChoosingInputAlerter.InputRuleDummy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputValidatorImpAlertingTest {

    private InputRuleDummy rule = new InputRuleDummy();
    private InputAlerterSpy alerter = new InputAlerterSpy();
    private InputValidatorImp sut = new InputValidatorImp(rule, alerter);

    @Test
    void IfInputGetsAlerted_TheInputAlerterShouldAlertTheInput() {
        Input input = new Input(0, 1);

        sut.alertIsInvalid(input);

        assertAlertedInputEquals(new Input(0, 1));
    }

    private void assertAlertedInputEquals(Input expected) {
        Input actual = alerter.getAlerted();
        assertEquals(expected, actual);
    }

}
