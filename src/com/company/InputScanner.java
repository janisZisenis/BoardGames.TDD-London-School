package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputScanner {

    static String rowMessage = "Input row:";
    static String columnMessage = "Input column:";
    static String errorMessage = "Error, please insert again:";

    public static UserInput scan() {
        int row = scanInt(rowMessage);
        int col = scanInt(columnMessage);

        return makeUserInput(row, col);
    }

    private static int scanInt(String scanMessage) {
        System.out.print(scanMessage);

        Scanner scanner = makeScanner();
        try{
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return scanInt(errorMessage);
        }
    }

    private static Scanner makeScanner() {
        return new Scanner(System.in);
    }

    private static UserInput makeUserInput(int row, int col) {
        return new UserInput(row, col);
    }
}