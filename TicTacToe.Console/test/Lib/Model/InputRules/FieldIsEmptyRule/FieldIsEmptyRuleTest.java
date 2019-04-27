package Lib.Model.InputRules.FieldIsEmptyRule;

import Lib.Data.Input.Input;
import Lib.Data.Field.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldIsEmptyRuleTest {

    private FieldIsEmptyProviderStub provider = new FieldIsEmptyProviderStub();
    private FieldIsEmptyRule sut = new FieldIsEmptyRule(provider);
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
