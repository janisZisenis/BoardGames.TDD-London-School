package com.company.InputGenerator;

import com.company.UserInput;

public class InputGenerator {
    private final InputPrompter scanner;

    public InputGenerator(InputPrompter scanner) {
        this.scanner = scanner;
    }

    public UserInput promptInput() {
        int row = scanner.promptRow();
        int col = scanner.promptColumn();

        return new UserInput(row, col);
    }
}
