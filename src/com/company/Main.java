package com.company;

import java.util.Scanner;

public class Main {

    static char[][] field = {   {'.', '.', '.'},
                                {'.', '.', '.'},
                                {'.', '.', '.'}   };

    public static void main(String[] args) {
        print(field);

        scanInput();

        print(field);
    }

    private static void scanInput() {
        Scanner in = makeScanner();
        int row = in.nextInt();
        int col = in.nextInt();
    }

    private static void print(char[][] field) {
        for(int row = 0; row < 3; row++) {
            printRow(row, field);
        }
    }

    private static void printRow(int row, char[][] field) {
        for(int col = 0; col < 3; col++) {
            System.out.print(field[col][row]);
        }
        System.out.print('\n');
    }

    private static Scanner makeScanner() {
        return new Scanner(System.in);
    }

}
