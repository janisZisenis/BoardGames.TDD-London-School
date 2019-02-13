package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        printEmptyField();

        scanInput();

    }

    private static void scanInput() {
        Scanner in = makeScanner();
        int row = in.nextInt();
        int col = in.nextInt();
    }

    private static void printEmptyField() {
        System.out.println("...");
        System.out.println("...");
        System.out.println("...");
    }

    private static Scanner makeScanner() {
        return new Scanner(System.in);
    }

}
