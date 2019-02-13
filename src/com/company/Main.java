package com.company;

import java.util.Scanner;

public class Main {

    static char[][] field = {   {'.', '.', '.'},
                                {'.', '.', '.'},
                                {'.', '.', '.'}   };

    public static void main(String[] args) {
        FieldPrinter.print(field);

        UserInput in = InputScanner.scan();
        apply(in);

        FieldPrinter.print(field);
    }

    private static void apply(UserInput in) {
        field[in.getRow()][in.getColumn()] = 'X';
    }

}
