package com.company;

import java.util.Scanner;

public class Main {

    static char[][] field = {   {'.', '.', '.'},
                                {'.', '.', '.'},
                                {'.', '.', '.'}   };

    public static void main(String[] args) {
        FieldPrinter.print(field);

        scanInput();

        FieldPrinter.print(field);
    }

    private static void scanInput() {
        Scanner in = makeScanner();
        int row = in.nextInt();
        int col = in.nextInt();
    }

    private static Scanner makeScanner() {
        return new Scanner(System.in);
    }

}
