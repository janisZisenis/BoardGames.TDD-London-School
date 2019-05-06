package View;

import InputGeneration.Input.Input;
import InputGeneration.InputGenerator;
import Messages.GenerationMessages;

import java.util.Scanner;

public class ConsoleInputGenerator implements InputGenerator {
    private final Scanner scanner = new Scanner(System.in);

    private final String rowMessage = GenerationMessages.rowMessage;
    private final String columnMessage = GenerationMessages.columnMessage;
    private final String notAnIntMessage = GenerationMessages.notAnIntMessage;

    public Input generate() {
        int row = promptInt(rowMessage);
        int column = promptInt(columnMessage);

        return new Input(row, column);
    }

    public int promptInt(String promptMessage) {
        printWithEndingSpace(promptMessage);

        while(noIntScanned()) {
            printWithLineBreak(notAnIntMessage);
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
