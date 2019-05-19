package FXView;

import InputGeneration.Input.Input;
import InputGeneration.InputGenerator;
import Messages.GenerationMessages;

import java.util.Scanner;

public class ConsoleInputGenerator implements InputGenerator {
    private static Scanner scanner;

    private final String rowMessage = GenerationMessages.rowMessage;
    private final String columnMessage = GenerationMessages.columnMessage;
    private final String notAnIntMessage = GenerationMessages.notAnIntMessage;

    public ConsoleInputGenerator() {
        resetScanner();
    }

    private static void resetScanner() {
        scanner = new Scanner(System.in);
    }

    public Input generate() {
        int row = promptInt(rowMessage);
        int column = promptInt(columnMessage);

        return new Input(row, column);
    }

    private int promptInt(String promptMessage) {
        int scanned = scanInt(promptMessage);
        resetScanner();
        return scanned;
    }

    private int scanInt(String promptMessage) {
        printWithEndingSpace(promptMessage);

        while(noIntScanned()) {
            printWithLineBreak(notAnIntMessage);
            printWithEndingSpace(promptMessage);
            resetScanner();
        }

        return getScannedInt();
    }

    private int getScannedInt() {
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

}
