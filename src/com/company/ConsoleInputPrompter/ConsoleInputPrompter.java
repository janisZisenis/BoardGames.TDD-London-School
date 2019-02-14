package com.company.ConsoleInputPrompter;

import com.company.InputGenerator.InputPrompter;

import java.util.Scanner;

public class ConsoleInputPrompter implements InputPrompter {
    private Scanner scanner = new Scanner(System.in);

    private final String rowMessage = "Input row:";
    private final String columnMessage = "Input column:";
    private final String errorMessage = "Error, please try again. ";

    public int promptRow() {
        return promptInt(rowMessage);
    }

    public int promptColumn() {
        return promptInt(columnMessage);
    }

    public int promptInt(String promtMessage) {
        print(promtMessage);

        int i = scan();
        while (i == -1) {
            print(errorMessage);
            skipLastScanned();
            i = promptInt(promtMessage);
        }

        return i;
    }

    private void print(String message) {
        System.out.print(message);
    }

    private int scan() {
        if (scanner.hasNextInt())
            return scanner.nextInt();
        return -1;
    }

    private void skipLastScanned() {
        scanner.next();
    }

}
