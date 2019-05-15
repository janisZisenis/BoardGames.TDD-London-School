package Domain.InputGeneration.InputValidators.FieldIsEmptyValidator;

import Domain.Data.Field.Field;
import InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FieldIsEmptyValidatorTest {

    private FieldIsEmptyProviderStub provider = new FieldIsEmptyProviderStub();
    private FieldIsEmptyValidator sut = new FieldIsEmptyValidator(provider);
    private Input input;

    @Test
    void IfInputRefersToAnEmptyField_ItShouldBeValid() {
        makeInputRefersToAnEmptyField();

        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

    @Test
    void IfInputRefersToAnOccupiedField_ItShouldNotBeValid() {
        makeInputRefersToAnOccupiedField();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    private void makeInputRefersToAnEmptyField() {
        input = new Input(0, 1);
        Field[] empty = { new Field(0, 1) };
        provider.setEmptyFields(empty);
    }

    private void makeInputRefersToAnOccupiedField() {
        input = new Input(0, 1);
        Field[] empty = {};
        provider.setEmptyFields(empty);
    }

}
