package com.company.Core.InputGeneration.PromptingInputGenerator;

import com.company.Core.InputGeneration.Input;

public class InputPrompterStub implements InputPrompter {
    private Input input;

    public void setInput(Input input) {
        this.input = input;
    }

    public int promptRow() {
        return input.getRow();
    }
    public int promptColumn() {
        return input.getColumn();
    }
}
