package com.company.CLI.InputGeneration;

import com.company.Core.InputGeneration.DefaultInputGenerator.InputPrompter;

import java.util.Scanner;

public class ConsoleInputPrompter implements InputPrompter {
    private Scanner scanner = new Scanner(System.in);

    private final String rowMessage = "Input row:";
    private final String columnMessage = "Input column:";
    private final String errorMessage = "Error, please try again. ";

    public int promptRow() {
        int i = promptInt(rowMessage);
        return i;
    }

    public int promptColumn() {
        return promptInt(columnMessage);
    }

    public int promptInt(String promptMessage) {
        print(promptMessage);

        return scanInt();
    }

    private int scanInt() {
        while(noIntScanned()) {
            print(errorMessage);
            skipLastScanned();
        }

        return scanner.nextInt();
    }

    private boolean noIntScanned() {
        return !scanner.hasNextInt();
    }

    private void print(String message) {
        System.out.print(message);
    }

    private void skipLastScanned() {
        scanner.next();
    }

}
