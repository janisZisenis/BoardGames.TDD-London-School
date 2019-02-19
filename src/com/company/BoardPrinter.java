package com.company;

public class BoardPrinter {

    public static void print(char[][] field) {
        for(int row = 0; row < 3; row++) {
            printRow(row, field);
        }
    }

    public static void printRow(int row, char[][] field) {
        for(int col = 0; col < 3; col++) {
            System.out.print(field[row][col]);
        }
        System.out.print('\n');
    }
}
