package Domain.InputGeneration.InputRules.FieldExistsRule;

import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FieldExistsRuleTest {

    private FieldExistsRule sut = new FieldExistsRule();
    private Input input;

    @Test
    void IfInputHasRowAndColumnBetween0And2_ItShouldBeValid() {
        input = new Input(0, 2);

        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

    @Test
    void IfInputHasNegativeRow_ItShouldNotBeValid() {
        input = new Input(-1, 2);

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void IfInputHasRowBiggerThan2_ItShouldNotBeValid() {
        input = new Input(3, 2);

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void IfInputHasNegativeColumn_ItShouldNotBeValid() {
        input = new Input(0, -1);

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void IfInputHasColumnBiggerThan2_ItShouldNotBeValid() {
        input = new Input(2, 3);

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

}
