package com.company;

import com.company.ConsoleInputPrompter.ConsoleInputPrompter;
import com.company.InputGenerator.InputGenerator;

public class Main {
    static char[][] field = {   {'.', '.', '.'},
                                {'.', '.', '.'},
                                {'.', '.', '.'}   };

    public static void main(String[] args) {
        ConsoleInputPrompter prompter = new ConsoleInputPrompter();
        InputGenerator generator = new InputGenerator(prompter);

        FieldPrinter.print(field);

        UserInput in = generator.generateInput();
        applyX(in);

        FieldPrinter.print(field);

        in = generator.generateInput();
        applyO(in);

        FieldPrinter.print(field);
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
