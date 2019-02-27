package com.company.TicTacToe.FieldExistsValidator;

import com.company.Core.InputGeneration.Input;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FieldExistsValidatorTest {

    FieldExistsProviderStub board = new FieldExistsProviderStub();
    FieldExistsValidator sut = new FieldExistsValidator(board);
    Input input = new Input(0, 1);

    @Test
    void IfUserInputIsOnBoard_ShouldBeTrue() {
        makeUserInputIsOnBoard();

        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

    @Test
    void IfUserInputIsNotOnBoard_ShouldBeFalse() {
        makeUserInputIsNotOnBoard();

        Input input = new Input(0, 1);
        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    private void makeUserInputIsOnBoard() {
        board.setFieldExists(true);
    }

    private void makeUserInputIsNotOnBoard() {
        board.setFieldExists(false);
    }
}
