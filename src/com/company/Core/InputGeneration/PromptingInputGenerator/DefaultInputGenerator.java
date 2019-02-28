package com.company.Core.InputGeneration.PromptingInputGenerator;

import com.company.Core.InputGeneration.InputGenerator;
import com.company.Core.InputGeneration.Input;

public class DefaultInputGenerator implements InputGenerator {
    private final InputPrompter prompter;

    public DefaultInputGenerator(InputPrompter prompter) {
        this.prompter = prompter;
    }

    public Input generateInput() {
        int row = prompter.promptRow();
        int col = prompter.promptColumn();

        return new Input(row, col);
    }
}
