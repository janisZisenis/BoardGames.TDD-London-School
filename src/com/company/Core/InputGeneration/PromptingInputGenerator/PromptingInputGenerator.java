package com.company.Core.InputGeneration.PromptingInputGenerator;

import com.company.Core.InputGeneration.InputValidatingGenerator.InputGenerator;
import com.company.Core.InputGeneration.Input.Input;

public class PromptingInputGenerator implements InputGenerator {
    private final InputPrompter prompter;

    public PromptingInputGenerator(InputPrompter prompter) {
        this.prompter = prompter;
    }

    public Input generate() {
        int row = prompter.promptRow();
        int col = prompter.promptColumn();

        return new Input(row, col);
    }
}