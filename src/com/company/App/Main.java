package com.company.App;

import com.company.CLI.TicTacToe.BoardPrinter;
import com.company.CLI.InputGeneration.ConsoleAlerter;
import com.company.CLI.InputGeneration.ConsoleInputPrompter;
import com.company.Core.InputGeneration.AlertingValidator.AlertingRule;
import com.company.Core.InputGeneration.CompositeRule.CompositeRule;
import com.company.Core.InputGeneration.InputValidatingGenerator.InputGenerator;
import com.company.Core.InputGeneration.InputRule;
import com.company.Core.InputGeneration.PromptingInputGenerator.PromptingInputGenerator;
import com.company.Core.InputGeneration.ValidatingInputGenerator.ValidatingInputGenerator;
import com.company.TicTacToe.Board.Board;
import com.company.CLI.TicTacToe.AlertingMessages;
import com.company.TicTacToe.CountingReferee.CountingReferee;
import com.company.TicTacToe.InputValidating.FieldExistsValidator.FieldExistsRule;
import com.company.TicTacToe.InputValidating.FieldIsEmptyValidator.FieldIsEmptyRule;
import com.company.Core.Turn.Turn;
import com.company.TicTacToe.Board.HashingBoard.HashingBoard;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Board.ObservableBoard.ObservableBoard;
import com.company.TicTacToe.Player.TicTacToePlayer;
import com.company.TicTacToe.Player.PlayerContext;

public class Main {

    private static ObservableBoard makeBoard() {
        Board hashing = new HashingBoard();
        return new ObservableBoard(hashing);
    }

    private static BoardPrinter makeBoardPrinter(Board board) {
        return new BoardPrinter(board);
    }

    private static InputGenerator makeTicTacToeInputGenerator(InputRule validator) {
        ConsoleInputPrompter prompter = new ConsoleInputPrompter();
        InputGenerator generator = new PromptingInputGenerator(prompter);
        return new ValidatingInputGenerator(generator, validator);
    }

    private static CompositeRule makeTicTacToeValidator(Board board) {
        InputRule existsValidator = makeAlertingFieldExistsValidator();
        InputRule isFreeValidator = makeAlertingFieldIsFreeValidator(board);

        CompositeRule validator = new CompositeRule();
        validator.add(existsValidator);
        validator.add(isFreeValidator);
        return validator;
    }

    private static CountingReferee makeTicTacToeReferee(ObservableBoard board) {
        return new CountingReferee(board);
    }

    private static InputRule makeAlertingFieldIsFreeValidator(Board board) {
        ConsoleAlerter alreadyMarkedAlerter = new ConsoleAlerter(AlertingMessages.inputAlreadyMarked);
        InputRule alreadyMarkedValidator = new FieldIsEmptyRule(board);
        return new AlertingRule(alreadyMarkedValidator, alreadyMarkedAlerter);
    }

    private static InputRule makeAlertingFieldExistsValidator() {
        ConsoleAlerter notExistingAlerter = new ConsoleAlerter(AlertingMessages.inputDoesNotExist);
        InputRule notExistingValidator = new FieldExistsRule();
        return new AlertingRule(notExistingValidator, notExistingAlerter);
    }

    private static TicTacToePlayer makeHaley(Board board, InputGenerator generator) {
        PlayerContext config = new PlayerContext(generator, board, Mark.Haley);
        return new TicTacToePlayer(config);
    }

    private static TicTacToePlayer makeJohn(Board board, InputGenerator generator) {
        PlayerContext config = new PlayerContext(generator, board, Mark.John);
        return new TicTacToePlayer(config);
    }

    private static Turn makeGame(com.company.Core.Turn.Player first, com.company.Core.Turn.Player second) {
        return new Turn(first, second);
    }

    public static void main(String[] args) {
        ObservableBoard board = makeBoard();
        BoardPrinter printer = makeBoardPrinter(board);
        board.attach(printer);

        InputRule validator = makeTicTacToeValidator(board);
        InputGenerator generator = makeTicTacToeInputGenerator(validator);
        CountingReferee referee = makeTicTacToeReferee(board);

        TicTacToePlayer john = makeJohn(board, generator);
        TicTacToePlayer haley = makeHaley(board, generator);
        Turn turn = makeGame(john, haley);

        printer.print();

        while(referee.hasMovesLeft()) {
            turn.play();
        }

    }

}
