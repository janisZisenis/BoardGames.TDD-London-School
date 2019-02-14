package com.company.InputGenerator;

import com.company.InputGenerator.InputPrompter;
import com.company.UserInput;

public class InputPrompterStub implements InputPrompter {
    UserInput input;

    public void setInput(UserInput input) {
        this.input = input;
    }

    public int promptRow() {
        return input.getRow();
    }
    public int promptColumn() {
        return input.getColumn();
    }
}
