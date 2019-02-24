package com.company;

import com.company.ConsoleInputPrompter.ConsoleInputPrompter;
import com.company.DefaultInputGenerator.DefaultInputGenerator;
import com.company.IsOnBoardValidatorImp.Field;
import com.company.IsOnBoardValidatorImp.IsOnBoardValidatorImp;
import com.company.TicTacToeBoard.Mark;
import com.company.TicTacToeBoard.TicTacToeBoard;

public class Main {

    static TicTacToeBoard board = new TicTacToeBoard();

    public static void main(String[] args) {
        ConsoleInputPrompter prompter = new ConsoleInputPrompter();
        DefaultInputGenerator generator = new DefaultInputGenerator(prompter);
        IsOnBoardValidatorImp validator = new IsOnBoardValidatorImp(board);

        print(board);

        UserInput in = generator.generateInput();
        Field f = makeField(in);
        while(!board.exists(f)) {
            System.out.println("The inserted input is out of bounds. Please insert again!");
            in = generator.generateInput();
        }
        applyJohn(f);

        print(board);


        in = generator.generateInput();
        f = makeField(in);
        while(!board.exists(f)) {
            System.out.println("The inserted input is out of bounds. Please insert again!");
            in = generator.generateInput();
        }
        applyHaley(f);

        print(board);

        in = generator.generateInput();
        f = makeField(in);
        while(!board.exists(f)) {
            System.out.println("The inserted input is out of bounds. Please insert again!");
            in = generator.generateInput();
        }
        applyJohn(f);

        print(board);
    }

    //Player
    private static void applyJohn(Field f) {
        mark(Mark.John, f);
    }

    private static void applyHaley(Field f) {
        mark(Mark.Haley, f);
    }

    private static void mark(Mark m, Field f) {
        board.mark(f, m);
    }

    private static Field makeField(UserInput in) {
        return new Field(in.getRow(), in.getColumn());
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
                char c = map(Main.board.getMarkAt(f));
                System.out.print(c);
            }
        }
        System.out.print('\n');
    }

    private static char map(Mark m) {
        return (m == Mark.John) ? 'X' : 'O';
    }

}
