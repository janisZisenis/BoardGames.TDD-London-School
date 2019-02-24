package com.company.IsOnBoardValidatorImp;

import com.company.UserInput;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IsOnBoardValidatorImpTest {

    BoardStub board = new BoardStub();
    IsOnBoardValidatorImp sut = new IsOnBoardValidatorImp(board);
    UserInput input = new UserInput(0, 1);

    @Test
    void IfUserInputIsOnBoard_ShouldBeTrue() {
        makeUserInputIsOnBoard();

        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

    @Test
    void IfUserInputIsNotOnBoard_ShouldBeFalse() {
        makeUserInputIsNotOnBoard();

        UserInput input = new UserInput(0, 1);
        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    private void makeUserInputIsOnBoard() {
        board.setUserInputIsOnBoard(true);
    }

    private void makeUserInputIsNotOnBoard() {
        board.setUserInputIsOnBoard(false);
    }
}
