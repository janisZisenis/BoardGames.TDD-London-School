package InputGeneration.MappingInputAlerter;

import InputGeneration.Input.Input;
import InputGeneration.InputValidatorImp.InputAlerterDummy;
import InputGeneration.InputValidatorImp.InputAlerterSpy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MappingInputAlerterTest {

    private MappingInputAlerter sut = new MappingInputAlerter();
    private InputAlerterSpy alerter = new InputAlerterSpy();

    private Input input = new Input(0, 1);

    @Test
    void IfFirstIsInvalidating_TheFirstAlerterShouldAlert() {
        makeAlerterIsRegisteredWithInvalidating();

        sut.alert(input);

        assertAlertedInputEquals(input);
    }

    @Test
    void IfFirstIsValidating_TheFirstAlerterShouldNotAlert() {
        makeAlerterIsRegisteredWithValidating();

        sut.alert(input);

        assertHasAlerted();
    }

    @Test
    void IfFirstIsInvalidatingAndSecondIsValidating_TheFirstAlerterShouldAlert() {
        makeAlerterIsRegisteredWithInvalidating();
        makeDummyIsRegisteredWithInvalidating();

        sut.alert(input);

        assertAlertedInputEquals(input);
    }

    @Test
    void IfFirstIsValidatingAndSecondIsInvalidating_TheSecondAlerterShouldAlert() {
        makeDummyIsRegisteredWithInvalidating();
        makeAlerterIsRegisteredWithInvalidating();

        sut.alert(input);

        assertAlertedInputEquals(input);
    }

    @Test
    void IfThirdAndSecondsAreInvalidatingAndFirstIsValidating_TheSecondAlerterShouldAlert() {
        makeDummyIsRegisteredWithValidating();
        makeAlerterIsRegisteredWithInvalidating();
        makeDummyIsRegisteredWithInvalidating();

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

    private void makeAlerterIsRegisteredWithInvalidating() {
        InputValidatorStub validator = makeInvalidating();
        sut.register(validator, alerter);
    }

    private void makeAlerterIsRegisteredWithValidating() {
        InputValidatorStub validator = makeValidating();
        sut.register(validator, alerter);
    }

    private void makeDummyIsRegisteredWithInvalidating() {
        InputValidatorStub validator = makeInvalidating();
        InputAlerterDummy dummy = new InputAlerterDummy();
        sut.register(validator, dummy);
    }

    private void makeDummyIsRegisteredWithValidating() {
        InputValidatorStub validator = makeValidating();
        InputAlerterDummy dummy = new InputAlerterDummy();
        sut.register(validator, dummy);
    }

    private InputValidatorStub makeInvalidating() {
        InputValidatorStub validator = new InputValidatorStub();
        Input[] valids = {};
        validator.setValidInputs(valids);
        return validator;
    }

    private InputValidatorStub makeValidating() {
        InputValidatorStub validator = new InputValidatorStub();
        Input[] valids = {input};
        validator.setValidInputs(valids);
        return validator;
    }

}
