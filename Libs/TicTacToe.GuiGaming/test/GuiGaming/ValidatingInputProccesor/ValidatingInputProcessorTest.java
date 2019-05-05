package GuiGaming.ValidatingInputProccesor;

import Domain.Data.Field.Field;
import GuiGaming.ValidatingInputProcessor.ValidatingInputProcessor;
import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ValidatingInputProcessorTest {

    private GuiTurnSpy turn = new GuiTurnSpy();
    private InputValidatorSpy validator = new InputValidatorSpy();
    private ValidatingInputProcessor sut = new ValidatingInputProcessor(turn, validator);

    @Test
    void IfValidInputIsR0C0_ShouldPlayFieldR0C0() {
        Input input = new Input(0, 0);
        makeIsValid(input);

        sut.process(input);

        Field field = new Field(0, 0);
        assertHasPlayed(field);
    }

    @Test
    void IfValidInputIsR1C2_ShouldPlayFieldR1C2() {
        Input input = new Input(1, 2);
        makeIsValid(input);

        sut.process(input);

        Field field = new Field(1, 2);
        assertHasPlayed(field);
    }

    @Test
    void IfInputIsInvalid_ShouldNotPlay() {
        Input input = new Input(0, 0);

        sut.process(input);

        assertHasNotPlayed();
    }

    @Test
    void IfInputIsInvalid_ShouldAlert() {
        Input input = new Input(0, 0);

        sut.process(input);

        assertHasAlerted(input);
    }

    @Test
    void IfInputIsValid_ShouldNotAlert() {
        Input input = new Input(0, 0);
        makeIsValid(input);

        sut.process(input);

        assertHasNotAlerted();
    }

    private void makeIsValid(Input input) {
        Input[] inputs = new Input[] { input };
        validator.setValidInputs(inputs);
    }

    private void assertHasNotAlerted() {
        boolean actual = validator.hasAlerted();
        assertFalse(actual);
    }

    private void assertHasAlerted(Input expected) {
        Input actual = validator.getAlertedInput();
        assertEquals(expected, actual);
    }

    private void assertHasNotPlayed() {
        boolean actual = turn.hasPlayed();
        assertFalse(actual);
    }


    private void assertHasPlayed(Field expected) {
        Field actual = turn.getPlayedField();
        assertEquals(expected, actual);
    }

}
