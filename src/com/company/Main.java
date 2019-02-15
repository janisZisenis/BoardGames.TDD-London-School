package com.company;

import com.company.ConsoleInputPrompter.ConsoleInputPrompter;
import com.company.DefaultInputGenerator.DefaultInputGenerator;

public class Main {
    static char[][] field = {   {'.', '.', '.'},
                                {'.', '.', '.'},
                                {'.', '.', '.'}   };

    public static void main(String[] args) {
        ConsoleInputPrompter prompter = new ConsoleInputPrompter();
        DefaultInputGenerator generator = new DefaultInputGenerator(prompter);

        FieldPrinter.print(field);

        UserInput in = generator.generateInput();
        while(isOutOfBounds(in)) {
            System.out.println("The inserted input is out of bounds. Please insert again!");
            in = generator.generateInput();
        }
        applyX(in);

        while(isOutOfBounds(in)) {
            in = generator.generateInput();
        }
        FieldPrinter.print(field);

        in = generator.generateInput();
        while(isOutOfBounds(in)) {
            System.out.println("The inserted input is out of bounds. Please insert again!");
            in = generator.generateInput();
        }
        applyO(in);

        FieldPrinter.print(field);
    }

    private static boolean isOutOfBounds(UserInput in) {
        return in.getColumn() < 0 || in.getColumn() > 2 || in.getRow() < 0 || in.getRow() > 2;
    }

    private static void applyX(UserInput in) {
        applyFor('X', in);
    }

    private static void applyO(UserInput in) {
        applyFor('O', in);
    }

    private static void applyFor(char player, UserInput in) {
        field[in.getRow()][in.getColumn()] = player;
    }

}
