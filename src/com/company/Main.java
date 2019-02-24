package com.company;

import com.company.ConsoleInputPrompter.ConsoleInputPrompter;
import com.company.DefaultInputGenerator.DefaultInputGenerator;
import com.company.IsOnBoardValidatorImp.Field;
import com.company.TicTacToeBoard.Mark;
import com.company.TicTacToeBoard.TicTacToeBoard;

public class Main {

    static TicTacToeBoard complex = new TicTacToeBoard();

    public static void main(String[] args) {
        ConsoleInputPrompter prompter = new ConsoleInputPrompter();
        DefaultInputGenerator generator = new DefaultInputGenerator(prompter);

        print(complex);

        UserInput in = generator.generateInput();
        Field f = makeField(in);
        while(!complex.exists(f)) {
            System.out.println("The inserted input is out of bounds. Please insert again!");
            in = generator.generateInput();
        }
        applyX(f);

        print(complex);


        in = generator.generateInput();
        f = makeField(in);
        while(!complex.exists(f)) {
            System.out.println("The inserted input is out of bounds. Please insert again!");
            in = generator.generateInput();
        }
        applyO(f);

        print(complex);

        in = generator.generateInput();
        f = makeField(in);
        while(!complex.exists(f)) {
            System.out.println("The inserted input is out of bounds. Please insert again!");
            in = generator.generateInput();
        }
        applyX(f);

        print(complex);
    }

    private static Field makeField(UserInput in) {
        return new Field(in.getRow(), in.getColumn());
    }


    //Player
    private static void applyX(Field f) {
        mark(Mark.X, f);
    }

    private static void applyO(Field f) {
        mark(Mark.O, f);
    }

    private static void mark(Mark m, Field f) {
        complex.mark(f, m);
    }


    //Printer
    public static void print(TicTacToeBoard board) {
        for(int row = 0; row < 3; row++) {
            printRow(row, board);
        }
    }

    public static void printRow(int row, TicTacToeBoard board) {
        for(int col = 0; col < 3; col++) {
            Field f = new Field(row, col);
            if(board.isEmpty(f)) {
                System.out.print('.');
            }
            else {
                char c = map(complex.getMarkAt(f));
                System.out.print(c);
            }
        }
        System.out.print('\n');
    }

    private static char map(Mark m) {
        return (m == Mark.X) ? 'X' : 'O';
    }

}
