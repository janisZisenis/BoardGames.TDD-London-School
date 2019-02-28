package com.company.Core.InputGeneration.PromptingInputGenerator;

import com.company.Core.InputGeneration.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PromptingInputGeneratorTest {

    private InputPrompterStub prompter = new InputPrompterStub();
    private DefaultInputGenerator sut = new DefaultInputGenerator(prompter);

    @Test
    void IfPrompterReturnsRow0AndColumn1_ShouldReturnUserInputWithRow0AndColumn1() {
        makePrompterReturnsUserInputWith(0, 1);

        Input actual = sut.generateInput();

        Input expected = createUserInput(0, 1);
        assertEquals(expected, actual);
    }

    @Test
    void IfPrompterReturnsRow1AndColumn2_ShouldReturnUserInputWithRow1AndColumn2() {
        makePrompterReturnsUserInputWith(1, 2);

        Input actual = sut.generateInput();

        Input expected = createUserInput(1, 2);
        assertEquals(expected, actual);
    }

    @Test
    void IfPrompterReturnsRow2AndColumn3_ShouldReturnUserInputWithRow2AndColumn3() {
        makePrompterReturnsUserInputWith(2, 3);

        Input actual = sut.generateInput();

        Input expected = createUserInput(2, 3);
        assertEquals(expected, actual);
    }

    private void makePrompterReturnsUserInputWith(int row, int col) {
        Input input = createUserInput(row, col);
        prompter.setInput(input);
    }

    private Input createUserInput(int row, int col) {
        return new Input(row, col);
    }

}
