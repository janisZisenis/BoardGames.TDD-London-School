package InputGeneration.InputValidatorImp;

import InputGeneration.Input.Input;
import InputGeneration.MappingInputAlerter.InputValidatorDummy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertingInputValidatorImpAlertingTest {

    private InputValidatorDummy validator = new InputValidatorDummy();
    private InputAlerterSpy alerter = new InputAlerterSpy();
    private AlertingInputValidatorImp sut = new AlertingInputValidatorImp(validator, alerter);

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
