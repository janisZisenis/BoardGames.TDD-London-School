package com.company.Core.InputGeneration.PromptingInputGenerator;

import com.company.Core.InputGeneration.Input.Input;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PromptingInputGeneratorTest {

    private InputPrompterStub prompter = new InputPrompterStub();
    private PromptingInputGenerator sut = new PromptingInputGenerator(prompter);

    @Test
    void IfPrompterReturnsRow0AndColumn1_UserInputShouldHaveRow0AndColumn1() {
        makePrompterReturns(0, 1);

        Input actual = sut.generateInput();

        Input expected = new Input(0, 1);
        assertEquals(expected, actual);
    }

    @Test
    void IfPrompterReturnsRow1AndColumn2_UserInputShouldHaveRow1AndColumn2() {
        makePrompterReturns(1, 2);

        Input actual = sut.generateInput();

        Input expected = new Input(1, 2);
        assertEquals(expected, actual);
    }

    @Test
    void IfPrompterReturnsRow2AndColumn3_UserInputShouldHaveRow2AndColumn3() {
        makePrompterReturns(2, 3);

        Input actual = sut.generateInput();

        Input expected = new Input(2, 3);
        assertEquals(expected, actual);
    }


    private void makePrompterReturns(int row, int column) {
        Input input = new Input(row, column);
        prompter.setInput(input);
    }

}
