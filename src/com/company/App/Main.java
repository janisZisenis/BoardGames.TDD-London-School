package com.company.App;

import com.company.CLI.InputGeneration.ConsoleAlerter;
import com.company.CLI.InputGeneration.ConsoleInputPrompter;
import com.company.CLI.TicTacToe.AlertingMessages;
import com.company.CLI.TicTacToe.BoardPrinter;
import com.company.Core.InputGeneration.ValidatingInputGenerator.InputGenerator;
import com.company.Core.InputGeneration.ValidatingInputGenerator.InputRule;
import com.company.Core.InputGeneration.ValidatingInputGenerator.ValidatingInputGenerator;
import com.company.Core.InputRules.AlertingRule.AlertingRule;
import com.company.Core.InputRules.CompositeRule.CompositeRule;
import com.company.Core.Turn.Player;
import com.company.Core.Turn.Turn;
import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.HashingBoard.HashingBoard;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Board.ObservableBoard.ObservableBoard;
import com.company.TicTacToe.GameOverRule.WinnerRule.WinnerRule;
import com.company.TicTacToe.GameOverRule.TieGameRule.TieGameRule;
import com.company.TicTacToe.InputValidating.FieldExistsRule.FieldExistsRule;
import com.company.TicTacToe.InputValidating.FieldIsEmptyRule.FieldIsEmptyRule;
import com.company.TicTacToe.LineEvaluator.TicTacToeLineEvaluator;
import com.company.TicTacToe.Player.PlayerContext;
import com.company.TicTacToe.Player.TicTacToePlayer;

public class Main {

    private static ObservableBoard makeBoard() {
        Board hashing = new HashingBoard();
        return new ObservableBoard(hashing);
    }

    private static BoardPrinter makeBoardPrinter(Board board) {
        return new BoardPrinter(board);
    }

    private static InputGenerator makeTicTacToeInputGenerator(InputRule rule) {
        ConsoleInputPrompter prompter = new ConsoleInputPrompter();
        return new ValidatingInputGenerator(prompter, rule);
    }

    private static CompositeRule makeTicTacToeInputRule(Board board) {
        InputRule existsValidator = makeAlertingFieldExistsValidator();
        InputRule isFreeValidator = makeAlertingFieldIsFreeValidator(board);

        CompositeRule validator = new CompositeRule();
        validator.add(existsValidator);
        validator.add(isFreeValidator);
        return validator;
    }

    private static TieGameRule makeTicTacToeReferee(Board board) {
        return new TieGameRule(board);
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

    private static Turn makeTurn(Player first, Player second) {
        return new Turn(first, second);
    }

    private static Turn makeTicTacToeTurn(Board board) {
        InputRule inputRule = makeTicTacToeInputRule(board);
        InputGenerator generator = makeTicTacToeInputGenerator(inputRule);

        TicTacToePlayer john = makeJohn(board, generator);
        TicTacToePlayer haley = makeHaley(board, generator);

        return makeTurn(john, haley);
    }

    private static WinnerRule makeGameHasWinnerReferee(Board board) {
        TicTacToeLineEvaluator evaluator = new TicTacToeLineEvaluator(board);
        TicTacToeLineProvider provider = new TicTacToeLineProvider();
        return new WinnerRule(provider, evaluator);
    }

    private static void initializeBoard() {
        ObservableBoard board = makeBoard();
        BoardPrinter printer = makeBoardPrinter(board);
        board.attach(printer);
        Main.board = board;
    }



    private static Board board;
    private static TieGameRule tieRule;
    private static WinnerRule winnerRule;

    public static void main(String[] args) {
        initializeBoard();

        Turn turn = makeTicTacToeTurn(board);

        tieRule = makeTicTacToeReferee(board);
        winnerRule = makeGameHasWinnerReferee(board);


        while(isGameOver()) {
            turn.play();
        }

    }

    private static boolean isGameOver() {
        return tieRule.hasMovesLeft() && !winnerRule.hasWinner();
    }

}
