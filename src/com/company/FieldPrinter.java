package com.company;

public class FieldPrinter {

    public static void print(char[][] field) {
        for(int row = 0; row < 3; row++) {
            printRow(row, field);
        }
    }

    public static void printRow(int row, char[][] field) {
        for(int col = 0; col < 3; col++) {
            System.out.print(field[col][row]);
        }
        System.out.print('\n');
    }
}
