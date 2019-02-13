package com.company;

import java.util.Scanner;

public class Main {

    static char[][] field = {   {'.', '.', '.'},
                                {'.', '.', '.'},
                                {'.', '.', '.'}   };

    public static void main(String[] args) {
        FieldPrinter.print(field);

        UserInput in = scanInput();

        FieldPrinter.print(field);
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

    private static class UserInput {
        private int row;
        private int column;

        public UserInput(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }

}
