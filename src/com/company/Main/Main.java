package com.company.Main;

import com.company.CLI.TicTacToe.BoardPrinter;
import com.company.CLI.InputGeneration.ConsoleAlerter;
import com.company.CLI.InputGeneration.ConsoleInputPrompter;
import com.company.Core.InputGeneration.AlertingValidator.AlertingValidator;
import com.company.Core.InputGeneration.CompositeValidator.CompositeValidator;
import com.company.Core.InputGeneration.InputGenerator;
import com.company.Core.InputGeneration.InputValidator;
import com.company.Core.InputGeneration.PromptingInputGenerator.PromptingInputGenerator;
import com.company.Core.InputGeneration.ValidatingInputGenerator.ValidatingInputGenerator;
import com.company.TicTacToe.Board.Board;
import com.company.CLI.TicTacToe.AlertingMessages;
import com.company.TicTacToe.CountingReferee.CountingReferee;
import com.company.TicTacToe.InputValidating.FieldExistsValidator.FieldExistsValidator;
import com.company.TicTacToe.InputValidating.FieldIsEmptyValidator.FieldIsEmptyValidator;
import com.company.Core.Turn.Turn;
import com.company.TicTacToe.Board.HashingBoard.HashingBoard;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Board.ObservableBoard.ObservableBoard;
import com.company.TicTacToe.Player.Player;
import com.company.TicTacToe.Player.PlayerConfig;

public class Main {

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

    private static CountingReferee makeTicTacToeReferee(ObservableBoard board) {
        return new CountingReferee(board);
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

    private static Turn makeGame(com.company.Core.Turn.Player first, com.company.Core.Turn.Player second) {
        return new Turn(first, second);
    }

    public static void main(String[] args) {
        ObservableBoard board = makeBoard();
        BoardPrinter printer = makeBoardPrinter(board);
        board.attach(printer);

        InputValidator validator = makeTicTacToeValidator(board);
        InputGenerator generator = makeTicTacToeInputGenerator(validator);
        CountingReferee referee = makeTicTacToeReferee(board);

        Player john = makeJohn(board, generator);
        Player haley = makeHaley(board, generator);
        Turn turn = makeGame(john, haley);

        printer.print();

        while(referee.hasMovesLeft()) {
            turn.play();
        }

    }

}
