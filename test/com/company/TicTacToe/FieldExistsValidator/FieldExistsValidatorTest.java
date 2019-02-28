package com.company.TicTacToe.FieldExistsValidator;

import com.company.Core.InputGeneration.Input;
import com.company.TicTacToe.Field;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FieldExistsValidatorTest {

    private FieldExistsProviderStub provider = new FieldExistsProviderStub();
    private FieldExistsValidator sut = new FieldExistsValidator(provider);
    private Input input = new Input(0, 1);

    @Test
    void IfUserInputRefersToAnExistingField_ShouldBeTrue() {
        makeUserInputRefersToAnExistingField();

        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

    @Test
    void IfUserInputRefersToANonExistingField_ShouldBeFalse() {
        makeUserInputRefersToANonExistingField();

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    private void makeUserInputRefersToAnExistingField() {
        Field[] existing = { new Field (0, 1) };
        provider.setExistingFields(existing);
    }

    private void makeUserInputRefersToANonExistingField() {
        Field[] existing = {};
        provider.setExistingFields(existing);
    }
}
