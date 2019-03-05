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
import com.company.TicTacToe.Board;
import com.company.TicTacToe.Constants.AlertingMessages;
import com.company.TicTacToe.CountingReferee.CountingReferee;
import com.company.TicTacToe.FieldExistsValidator.FieldExistsValidator;
import com.company.TicTacToe.FieldIsEmptyValidator.FieldIsEmptyValidator;
import com.company.TicTacToe.HashingBoard.HashingBoard;
import com.company.TicTacToe.Mark;
import com.company.TicTacToe.ObservableBoard.ObservableBoard;
import com.company.TicTacToe.Player.PlayerImp;
import com.company.TicTacToe.Player.PlayerImpConfig;

public class Main {

    private static ObservableBoard board;
    private static PlayerImp current;
    private static PlayerImp john;
    private static PlayerImp haley;
    private static BoardPrinter printer;

    private static ObservableBoard makeBoard() {
        Board hashing = new HashingBoard();
        return new ObservableBoard(hashing);
    }

    private static BoardPrinter makeBoardPrinter(Board board) {
        return new BoardPrinter(board);
    }

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

    private static PlayerImp makeHaley(Board board, InputGenerator generator) {
        PlayerImpConfig config = new PlayerImpConfig(generator, board, Mark.Haley);
        return new PlayerImp(config);
    }

    private static PlayerImp makeJohn(Board board, InputGenerator generator) {
        PlayerImpConfig config = new PlayerImpConfig(generator, board, Mark.John);
        return new PlayerImp(config);
    }

    public static void main(String[] args) {
        board = makeBoard();
        printer = makeBoardPrinter(board);
        board.attach(printer);

        InputValidator validator = makeTicTacToeValidator(board);
        InputGenerator generator = makeTicTacToeInputGenerator(validator);
        CountingReferee referee = new CountingReferee(board);

        john = makeJohn(board, generator);
        haley = makeHaley(board, generator);
        current = john;

        printer.print();

        while(referee.hasMovesLeft()) {
            current.playMove();
            current = current == john ? haley : john;
        }

    }

}
