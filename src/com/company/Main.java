package com.company;

import com.company.CLI.InputGeneration.ConsoleInputPrompter;
import com.company.Core.InputGeneration.AlertingValidator.AlertingValidator;
import com.company.CLI.InputGeneration.ConsoleAlerter;
import com.company.Core.InputGeneration.CompositeValidator.CompositeValidator;
import com.company.Core.InputGeneration.InputGenerator;
import com.company.Core.InputGeneration.InputValidator;
import com.company.Core.InputGeneration.PromptingInputGenerator.DefaultInputGenerator;
import com.company.Core.InputGeneration.ValidatingInputGenerator.ValidatingInputGenerator;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Board.TicTacToeBoard;
import com.company.TicTacToe.Constants.AlertingMessages;
import com.company.TicTacToe.Field;
import com.company.TicTacToe.FieldExistsValidator.FieldExistsValidator;
import com.company.TicTacToe.FieldIsEmptyValidator.FieldIsEmptyValidator;
import com.company.TicTacToe.Player.Player;
import com.company.TicTacToe.Player.PlayerConfig;

public class Main {

    static TicTacToeBoard board = new TicTacToeBoard();

    private static InputGenerator makeTicTacToeInputGenerator(TicTacToeBoard board) {
        ConsoleAlerter notExistingAlerter = new ConsoleAlerter(AlertingMessages.inputDoesNotExist);
        InputValidator notExistingValidator = new FieldExistsValidator(board);
        InputValidator notExistingAlerting = new AlertingValidator(notExistingValidator, notExistingAlerter);

        ConsoleAlerter alreadyMarkedAlerter = new ConsoleAlerter(AlertingMessages.inputAlreadyMarked);
        InputValidator alreadyMarkedValidator = new FieldIsEmptyValidator(board);
        InputValidator alreadyMarkedAlerting = new AlertingValidator(alreadyMarkedValidator, alreadyMarkedAlerter);

        CompositeValidator validator = new CompositeValidator();
        validator.add(notExistingAlerting);
        validator.add(alreadyMarkedAlerting);

        ConsoleInputPrompter prompter = new ConsoleInputPrompter();
        InputGenerator generator = new DefaultInputGenerator(prompter);
        return new ValidatingInputGenerator(generator, validator);
    }

    private static Player makeHaley(TicTacToeBoard board, InputGenerator generator) {
        PlayerConfig config = new PlayerConfig(generator, board, Mark.Haley);
        return new Player(config);
    }

    private static Player makeJohn(TicTacToeBoard board, InputGenerator generator) {
        PlayerConfig config = new PlayerConfig(generator, board, Mark.John);
        return new Player(config);
    }

    public static void main(String[] args) {
        InputGenerator generator = makeTicTacToeInputGenerator(board);
        Player john = makeJohn(board, generator);
        Player haley = makeHaley(board, generator);

        print(board);

        john.play();

        print(board);

        haley.play();

        print(board);

        john.play();

        print(board);
    }

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
