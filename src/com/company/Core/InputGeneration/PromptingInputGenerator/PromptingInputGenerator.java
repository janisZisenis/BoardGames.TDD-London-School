package com.company.Core.InputGeneration.PromptingInputGenerator;

import com.company.Core.InputGeneration.InputGenerator;
import com.company.Core.InputGeneration.Input.Input;

public class PromptingInputGenerator implements InputGenerator {
    private final InputPrompter prompter;

    public PromptingInputGenerator(InputPrompter prompter) {
        this.prompter = prompter;
    }

    public Input generateInput() {
        int row = prompter.promptRow();
        int col = prompter.promptColumn();

        return new Input(row, col);
    }
}