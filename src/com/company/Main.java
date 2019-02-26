package com.company;

import com.company.Core.InputGeneration.AlertingValidator.AlertingValidator;
import com.company.Core.InputGeneration.Input;
import com.company.Core.InputGeneration.InputValidator;
import com.company.CLI.InputGeneration.ConsoleAlerter;
import com.company.CLI.InputGeneration.ConsoleInputPrompter;
import com.company.TicTacToe.Constants.AlertingMessages;
import com.company.Core.InputGeneration.DefaultInputGenerator.DefaultInputGenerator;
import com.company.TicTacToe.Field;
import com.company.TicTacToe.IsOnBoardValidator.FieldExistsValidator;
import com.company.TicTacToe.Board.Player;
import com.company.TicTacToe.Board.TicTacToeBoard;
import com.company.Core.InputGeneration.InputGenerator;
import com.company.Core.InputGeneration.ValidatingInputGenerator.ValidatingInputGenerator;
import com.company.TicTacToe.Player.Haley;
import com.company.TicTacToe.Player.John;

public class Main {

    static TicTacToeBoard board = new TicTacToeBoard();

    private static InputGenerator makeTicTacToeInputGenerator(TicTacToeBoard board) {
        ConsoleAlerter alerter = new ConsoleAlerter();
        InputValidator validator = new FieldExistsValidator(board);
        InputValidator alerting = new AlertingValidator(validator, alerter, AlertingMessages.inputOutOfBounds);

        ConsoleInputPrompter prompter = new ConsoleInputPrompter();
        InputGenerator generator = new DefaultInputGenerator(prompter);
        return new ValidatingInputGenerator(generator, alerting);
    }

    public static void main(String[] args) {
        InputGenerator generator = makeTicTacToeInputGenerator(board);
        John john = new John(generator, board);
        Haley haley = new Haley(generator, board);

        print(board);

        john.play();

        print(board);

        haley.play();

        print(board);

        john.play();

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

    private static Field makeField(Input in) {
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
