package com.company;

import com.company.AlertingValidator.AlertingValidator;
import com.company.CLImp.ConsoleAlerter;
import com.company.CLImp.ConsoleInputPrompter;
import com.company.Constants.AlertingMessages;
import com.company.DefaultInputGenerator.DefaultInputGenerator;
import com.company.IsOnBoardValidator.Field;
import com.company.IsOnBoardValidator.IsOnBoardValidator;
import com.company.TicTacToeBoard.Player;
import com.company.TicTacToeBoard.TicTacToeBoard;

public class Main {

    static TicTacToeBoard board = new TicTacToeBoard();

    public static void main(String[] args) {
        ConsoleInputPrompter prompter = new ConsoleInputPrompter();
        DefaultInputGenerator generator = new DefaultInputGenerator(prompter);
        IsOnBoardValidator validator = new IsOnBoardValidator(board);
        ConsoleAlerter alerter = new ConsoleAlerter();
        AlertingValidator alerting = new AlertingValidator(validator, alerter, AlertingMessages.inputOutOfBounds);

        print(board);

        UserInput in = generator.generateInput();
        Field f = makeField(in);
        while(!alerting.isValid(in)) {
            in = generator.generateInput();
            f = makeField(in);
        }
        applyJohn(f);

        print(board);

        in = generator.generateInput();
        f = makeField(in);
        while(!alerting.isValid(in)) {
            in = generator.generateInput();
            f = makeField(in);
        }
        applyHaley(f);

        print(board);

        in = generator.generateInput();
        f = makeField(in);
        while(!alerting.isValid(in)) {
            in = generator.generateInput();
            f = makeField(in);
        }
        applyJohn(f);

        print(board);
    }

    //Player
    private static void applyJohn(Field f) {
        mark(Player.John, f);
    }

    private static void applyHaley(Field f) {
        mark(Player.Haley, f);
    }

    private static void mark(Player m, Field f) {
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

    private static char map(Player m) {
        return (m == Player.John) ? 'X' : 'O';
    }

}
