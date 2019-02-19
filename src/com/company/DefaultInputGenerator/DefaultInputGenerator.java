package com.company.DefaultInputGenerator;

import com.company.OnBoardInputGenerator.InputGenerator;
import com.company.UserInput;

public class DefaultInputGenerator implements InputGenerator {
    private final InputPrompter scanner;

    public DefaultInputGenerator(InputPrompter scanner) {
        this.scanner = scanner;
    }

    public UserInput generateInput() {
        int row = scanner.promptRow();
        int col = scanner.promptColumn();

        return new UserInput(row, col);
    }
}
