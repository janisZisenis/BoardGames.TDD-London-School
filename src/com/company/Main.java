package com.company;

import java.util.Scanner;

public class Main {

    static char[][] field = {   {'.', '.', '.'},
                                {'.', '.', '.'},
                                {'.', '.', '.'}   };

    public static void main(String[] args) {
        FieldPrinter.print(field);

        UserInput in = scanInput();
        apply(in);

        FieldPrinter.print(field);
    }

    private static void apply(UserInput in) {
        field[in.getRow()][in.getColumn()] = 'X';
    }

    private static UserInput scanInput() {
        Scanner in = makeScanner();
        int row = in.nextInt();
        int col = in.nextInt();

        return makeUserInput(row, col);
    }

    private static UserInput makeUserInput(int row, int col) {
        return new UserInput(row, col);
    }

    private static Scanner makeScanner() {
        return new Scanner(System.in);
    }

}
