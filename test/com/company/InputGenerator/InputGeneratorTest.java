package com.company.InputGenerator;

import com.company.UserInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputGeneratorTest {

    InputPrompterStub prompter = new InputPrompterStub();
    InputGenerator sut = new InputGenerator(prompter);

    @Test
    void IfPrompterReturnsRow0AndColumn1_ShouldReturnUserInputWithRow0AndColumn1() {
        makePrompterReturnUserInputWith(0, 1);

        UserInput actual = sut.generateInput();

        UserInput expected = createUserInput(0, 1);
        assertEquals(expected, actual);
    }

    @Test
    void IfPrompterReturnsRow1AndColumn2_ShouldReturnUserInputWithRow1AndColumn2() {
        makePrompterReturnUserInputWith(1, 2);

        UserInput actual = sut.generateInput();

        UserInput expected = createUserInput(1, 2);
        assertEquals(expected, actual);
    }

    @Test
    void IfPrompterReturnsRow2AndColumn3_ShouldReturnUserInputWithRow2AndColumn3() {
        makePrompterReturnUserInputWith(2, 3);

        UserInput actual = sut.generateInput();

        UserInput expected = createUserInput(2, 3);
        assertEquals(expected, actual);
    }

    private void makePrompterReturnUserInputWith(int row, int col) {
        UserInput input = createUserInput(row, col);
        prompter.setInput(input);
    }

    private UserInput createUserInput(int row, int col) {
        return new UserInput(row, col);
    }

}
