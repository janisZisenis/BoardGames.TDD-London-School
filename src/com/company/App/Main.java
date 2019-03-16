package com.company.App;

import com.company.CLI.InputGeneration.ConsoleInputPrompter;
import com.company.CLI.TicTacToe.BoardPrinter;
import com.company.Core.CompositeGameOverRule.CompositeGameOverRule;
import com.company.Core.InputGeneration.ValidatingInputGenerator.InputGenerator;
import com.company.Core.InputGeneration.ValidatingInputGenerator.InputRule;
import com.company.Core.InputGeneration.ValidatingInputGenerator.ValidatingInputGenerator;
import com.company.Core.CompositeInputRule.CompositeInputRule;
import com.company.Core.Turn.Player;
import com.company.Core.Turn.Turn;
import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.HashingBoard.HashingBoard;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Board.ObservableBoard.ObservableBoard;
import com.company.TicTacToe.GameOverRules.NumberOfMovesRule.NumberOfMovesRule;
import com.company.TicTacToe.GameOverRules.WinningLineRule.WinningLineRule;
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

    private static InputRule makeTicTacToeInputRule(Board board) {
        InputRule existsValidator = new FieldExistsRule();
        InputRule isFreeValidator = new FieldIsEmptyRule(board);

        CompositeInputRule composite = new CompositeInputRule();
        composite.add(existsValidator);
        composite.add(isFreeValidator);

        return composite;
    }

    private static NumberOfMovesRule makeNumberOfMovesRule(Board board) {
        return new NumberOfMovesRule(board);
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

    private static WinningLineRule makeWinningLineRule(Board board) {
        TicTacToeLineEvaluator evaluator = new TicTacToeLineEvaluator(board);
        TicTacToeLineProvider provider = new TicTacToeLineProvider();
        return new WinningLineRule(provider, evaluator);
    }

    private static CompositeGameOverRule makeTicTacToeGameOverRule(Board board) {
        NumberOfMovesRule numberOfMovesRule = makeNumberOfMovesRule(board);
        WinningLineRule winningLineRule = makeWinningLineRule(board);

        CompositeGameOverRule rule = new CompositeGameOverRule();
        rule.add(numberOfMovesRule);
        rule.add(winningLineRule);
        return rule;
    }

    private static void initializeBoard() {
        ObservableBoard board = makeBoard();
        BoardPrinter printer = makeBoardPrinter(board);
        board.attach(printer);
        Main.board = board;
    }

    private static Board board;

    public static void main(String[] args) {
        initializeBoard();

        Turn turn = makeTicTacToeTurn(board);
        CompositeGameOverRule rule = makeTicTacToeGameOverRule(board);

        while(!rule.isGameOver()) {
            turn.play();
        }

    }

}
