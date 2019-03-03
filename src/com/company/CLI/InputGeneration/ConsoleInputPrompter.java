package com.company.CLI.InputGeneration;

import com.company.Core.InputGeneration.PromptingInputGenerator.InputPrompter;

import java.util.Scanner;

public class ConsoleInputPrompter implements InputPrompter {
    private final Scanner scanner = new Scanner(System.in);

    private final String rowMessage = "Input row:";
    private final String columnMessage = "Input column:";
    private final String errorMessage = "The input has to be an integer.";

    public int promptRow() {
        return promptInt(rowMessage);
    }

    public int promptColumn() {
        return promptInt(columnMessage);
    }

    public int promptInt(String promptMessage) {
        printWithEndingSpace(promptMessage);

        while(noIntScanned()) {
            printWithLineBreak(errorMessage);
            printWithEndingSpace(promptMessage);
            skipLastScanned();
        }

        return scanner.nextInt();
    }

    private boolean noIntScanned() {
        return !scanner.hasNextInt();
    }

    private void printWithEndingSpace(String message) {
        System.out.print(message + " ");
    }

    private void printWithLineBreak(String message) {
        System.out.println(message);
    }

    private void skipLastScanned() {
        scanner.next();
    }

}
