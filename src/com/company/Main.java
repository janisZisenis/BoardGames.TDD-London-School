package com.company;

import java.util.Scanner;

public class Main {

    static char[][] field = {   {'.', '.', '.'},
                                {'.', '.', '.'},
                                {'.', '.', '.'}   };

    public static void main(String[] args) {
        printField();

        scanInput();

        printField();
    }

    private static void scanInput() {
        Scanner in = makeScanner();
        int row = in.nextInt();
        int col = in.nextInt();
    }

    private static void printField() {
        for(int row = 0; row < 3; row++) {
            printRow(row);
        }
    }

    private static void printRow(int row) {
        for(int col = 0; col < 3; col++) {
            System.out.print(field[col][row]);
        }
        System.out.print('\n');
    }

    private static Scanner makeScanner() {
        return new Scanner(System.in);
    }

}
