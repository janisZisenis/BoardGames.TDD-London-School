package InputGeneration.InputValidatorImp;

import InputGeneration.Input.Input;
import InputGeneration.MappingInputAlerter.InputValidatorStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AlertingInputValidatorImpValidatingTest {

    private InputValidatorStub validator = new InputValidatorStub();
    private InputAlerterDummy alerter = new InputAlerterDummy();
    private AlertingInputValidatorImp sut = new AlertingInputValidatorImp(validator, alerter);

    private Input input = new Input(0, 1);

    @Test
    void IfInputIsValid_ItShouldBeValidToo() {
        makeInputIsValid();

        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

    @Test
    void IfInputIsInvalid_ItShouldBeInvalidToo() {
        makeInputIsInvalid();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    private void makeInputIsValid() {
        Input[] valids = new Input[] { input };
        validator.setValidInputs(valids);
    }

    private void makeInputIsInvalid() {
        Input[] valids = new Input[] {};
        validator.setValidInputs(valids);
    }

}
