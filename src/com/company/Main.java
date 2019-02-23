package com.company;

import com.company.ConsoleInputPrompter.ConsoleInputPrompter;
import com.company.DefaultInputGenerator.DefaultInputGenerator;
import com.company.IsOnBoardValidatorImp.Field;
import com.company.IsOnBoardValidatorImp.IsOnBoardValidatorImp;
import com.company.OnBoardInputGenerator.OnBoardInputGenerator;
import com.company.TicTacToeBoard.Mark;

public class Main {
    static Mark[][] board = {   {null, null, null},
                                {null, null, null},
                                {null, null, null}   };

    public static void main(String[] args) {
        ConsoleInputPrompter prompter = new ConsoleInputPrompter();
        DefaultInputGenerator generator = new DefaultInputGenerator(prompter);
        IsOnBoardValidatorImp onBoardValidator = new IsOnBoardValidatorImp(null);
        OnBoardInputGenerator onBoardGenerator = new OnBoardInputGenerator(generator, onBoardValidator);

        print(board);

        UserInput in = generator.generateInput();
        while(exists(in)) {
            System.out.println("The inserted input is out of bounds. Please insert again!");
            in = generator.generateInput();
        }
        applyX(in);

        while(exists(in)) {
            in = generator.generateInput();
        }
        print(board);

        in = generator.generateInput();
        while(exists(in)) {
            System.out.println("The inserted input is out of bounds. Please insert again!");
            in = generator.generateInput();
        }
        applyO(in);

        print(board);
    }

    //Board
    private static boolean exists(UserInput in) {
        return in.getColumn() < 0 || in.getColumn() > 2 || in.getRow() < 0 || in.getRow() > 2;
    }

    private static boolean isEmpty(int row, int column) {
        return board[row][column] == null;
    }

    private static void mark(Mark m, Field f) {
        board[f.getRow()][f.getColumn()] = m;
    }

    //Player
    private static void applyX(UserInput in) {
        Field f = new Field(in.getRow(), in.getColumn());
        mark(Mark.X, f);
    }

    private static void applyO(UserInput in) {
        Field f = new Field(in.getRow(), in.getColumn());
        mark(Mark.O, f);

    }


    //Printer
    public static void print(Mark[][] board) {
        for(int row = 0; row < 3; row++) {
            printRow(row, board);
        }
    }

    public static void printRow(int row, Mark[][] board) {
        for(int col = 0; col < 3; col++) {
            if(isEmpty(row, col)) {
                System.out.print('.');
            }
            else {
                char c = map(board[row][col]);
                System.out.print(c);
            }
        }
        System.out.print('\n');
    }

    private static char map(Mark m) {
        return (m == Mark.X) ? 'X' : 'O';
    }

}
