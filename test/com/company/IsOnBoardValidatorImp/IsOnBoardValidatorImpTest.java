package com.company.IsOnBoardValidatorImp;

import com.company.UserInput;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class IsOnBoardValidatorImpTest {

    @Test
    void IfUserInputIsOnBoard_ShouldBeTrue() {
        IsOnBoardValidatorImp sut = new IsOnBoardValidatorImp();
        UserInput input = new UserInput(0, 1);

        boolean actual = sut.isOnBoard(input);

        assertTrue(actual);
    }

    @Test
    void IfUserInputIsNotOnBoard_ShouldBeFalse() {
        BoardStub field = new BoardStub();
        field.setUserInputIsOnBoard(false);
        IsOnBoardValidatorImp sut = new IsOnBoardValidatorImp(field);

        UserInput input = new UserInput(0, 1);
        boolean actual = sut.isOnBoard(input);

        assertFalse(actual);
    }
}
