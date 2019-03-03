package com.company;

import com.company.CLI.InputGeneration.BoardPrinter;
import com.company.CLI.InputGeneration.ConsoleAlerter;
import com.company.CLI.InputGeneration.ConsoleInputPrompter;
import com.company.Core.InputGeneration.AlertingValidator.AlertingValidator;
import com.company.Core.InputGeneration.CompositeValidator.CompositeValidator;
import com.company.Core.InputGeneration.InputGenerator;
import com.company.Core.InputGeneration.InputValidator;
import com.company.Core.InputGeneration.PromptingInputGenerator.PromptingInputGenerator;
import com.company.Core.InputGeneration.ValidatingInputGenerator.ValidatingInputGenerator;
import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Constants.AlertingMessages;
import com.company.TicTacToe.FieldExistsValidator.FieldExistsValidator;
import com.company.TicTacToe.FieldIsEmptyValidator.FieldIsEmptyValidator;
import com.company.TicTacToe.Player.Player;
import com.company.TicTacToe.Player.PlayerConfig;

public class Main {

    private static InputGenerator makeTicTacToeInputGenerator(InputValidator validator) {
        ConsoleInputPrompter prompter = new ConsoleInputPrompter();
        InputGenerator generator = new PromptingInputGenerator(prompter);
        return new ValidatingInputGenerator(generator, validator);
    }

    private static CompositeValidator makeTicTacToeValidator(Board board) {
        InputValidator existsValidator = makeAlertingFieldExistsValidator();
        InputValidator isFreeValidator = makeAlertingFieldIsFreeValidator(board);

        CompositeValidator validator = new CompositeValidator();
        validator.add(existsValidator);
        validator.add(isFreeValidator);
        return validator;
    }

    private static InputValidator makeAlertingFieldIsFreeValidator(Board board) {
        ConsoleAlerter alreadyMarkedAlerter = new ConsoleAlerter(AlertingMessages.inputAlreadyMarked);
        InputValidator alreadyMarkedValidator = new FieldIsEmptyValidator(board);
        return new AlertingValidator(alreadyMarkedValidator, alreadyMarkedAlerter);
    }

    private static InputValidator makeAlertingFieldExistsValidator() {
        ConsoleAlerter notExistingAlerter = new ConsoleAlerter(AlertingMessages.inputDoesNotExist);
        InputValidator notExistingValidator = new FieldExistsValidator();
        return new AlertingValidator(notExistingValidator, notExistingAlerter);
    }

    private static Player makeHaley(Board board, InputGenerator generator) {
        PlayerConfig config = new PlayerConfig(generator, board, Mark.Haley);
        return new Player(config);
    }

    private static Player makeJohn(Board board, InputGenerator generator) {
        PlayerConfig config = new PlayerConfig(generator, board, Mark.John);
        return new Player(config);
    }

    public static void main(String[] args) {
        Board board = new Board();
        InputValidator validator = makeTicTacToeValidator(board);
        InputGenerator generator = makeTicTacToeInputGenerator(validator);
        BoardPrinter printer = new BoardPrinter();

        Player john = makeJohn(board, generator);
        Player haley = makeHaley(board, generator);

        printer.print(board);
        john.playMove();

        printer.print(board);
        haley.playMove();

        printer.print(board);
        john.playMove();

        printer.print(board);
        haley.playMove();

        printer.print(board);
        john.playMove();

        printer.print(board);
        haley.playMove();

        printer.print(board);
    }

}
