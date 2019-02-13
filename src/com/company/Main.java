package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static char[][] field = {   {'.', '.', '.'},
                                {'.', '.', '.'},
                                {'.', '.', '.'}   };

    static String rowMessage = "Input row:";
    static String columnMessage = "Input column:";
    static String errorMessage = "Error, please insert again:";


    public static void main(String[] args) {
        FieldPrinter.print(field);

        UserInput in = scan();
        apply(in);

        FieldPrinter.print(field);
    }

    private static void apply(UserInput in) {
        field[in.getRow()][in.getColumn()] = 'X';
    }

    private static UserInput scan() {
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
