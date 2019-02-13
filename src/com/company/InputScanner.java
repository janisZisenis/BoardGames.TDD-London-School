package com.company;

import java.util.Scanner;

public class InputScanner {

    public static UserInput scan() {
        Scanner in = makeScanner();
        int row = in.nextInt();
        int col = in.nextInt();

        return makeUserInput(row, col);
    }

    private static Scanner makeScanner() {
        return new Scanner(System.in);
    }

    private static UserInput makeUserInput(int row, int col) {
        return new UserInput(row, col);
    }
}