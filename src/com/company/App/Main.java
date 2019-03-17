package com.company.App;

import com.company.CLI.Core.InputGeneration.ConsoleInputAlerter;
import com.company.CLI.Core.InputGeneration.ConsoleInputGenerator;
import com.company.CLI.TicTacToe.View.AlertingMessages;
import com.company.CLI.TicTacToe.View.BoardView;
import com.company.Core.GameOverRules.CompositeGameOverRule;
import com.company.Core.InputGeneration.InputRule.CompositeInputRule.CompositeInputRule;
import com.company.Core.InputGeneration.VerboseValidatingInputGenerator.InputRefereeImp.InputRefereeImp;
import com.company.Core.InputGeneration.InputRule.InputRule;
import com.company.Core.InputGeneration.VerboseValidatingInputGenerator.InputRefereeImp.RuleChoosingInputAlerter.RuleChoosingInputAlerter;
import com.company.Core.InputGeneration.InputGenerator;
import com.company.Core.InputGeneration.VerboseValidatingInputGenerator.VerboseValidatingInputGenerator;
import com.company.Core.Turn.Turn;
import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.HashingBoard.HashingBoard;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Board.ObservableBoard.ObservableBoard;
import com.company.TicTacToe.GameOverRules.NumberOfMovesRule.NumberOfMovesRule;
import com.company.TicTacToe.GameOverRules.WinningLineRule.WinningLineRule;
import com.company.TicTacToe.InputRules.FieldExistsRule.FieldExistsRule;
import com.company.TicTacToe.InputRules.FieldIsEmptyRule.FieldIsEmptyRule;
import com.company.TicTacToe.GameOverRules.WinningLineRule.LineEvaluatorImp.LineEvaluatorImp;
import com.company.TicTacToe.PlayerImp.PlayerContext;
import com.company.TicTacToe.PlayerImp.PlayerImp;

public class Main {

    private static ObservableBoard makeBoard() {
        Board hashing = new HashingBoard();
        return new ObservableBoard(hashing);
    }

    private static BoardView makeBoardPrinter(Board board) {
        return new BoardView(board);
    }

    private static PlayerImp makeHaley(Board board, InputGenerator generator) {
        PlayerContext config = new PlayerContext(generator, board, Mark.Haley);
        return new PlayerImp(config);
    }

    private static PlayerImp makeJohn(Board board, InputGenerator generator) {
        PlayerContext config = new PlayerContext(generator, board, Mark.John);
        return new PlayerImp(config);
    }

    private static Turn makeTicTacToeTurn(Board board) {
        InputRule existsRule = new FieldExistsRule();
        ConsoleInputAlerter existsAlerter = new ConsoleInputAlerter(AlertingMessages.inputDoesNotExist);
        InputRule isFreeRule = new FieldIsEmptyRule(board);
        ConsoleInputAlerter isFreeAlerter = new ConsoleInputAlerter(AlertingMessages.inputAlreadyMarked);

        RuleChoosingInputAlerter choosing = new RuleChoosingInputAlerter();
        choosing.register(existsRule, existsAlerter);
        choosing.register(isFreeRule, isFreeAlerter);

        CompositeInputRule composite = new CompositeInputRule();
        composite.add(existsRule);
        composite.add(isFreeRule);

        InputRefereeImp referee = new InputRefereeImp(composite, choosing);
        ConsoleInputGenerator prompter = new ConsoleInputGenerator();
        InputGenerator generator = new VerboseValidatingInputGenerator(prompter, referee);

        PlayerImp john = makeJohn(board, generator);
        PlayerImp haley = makeHaley(board, generator);

        return new Turn(john, haley);
    }

    private static NumberOfMovesRule makeNumberOfMovesRule(Board board) {
        return new NumberOfMovesRule(board);
    }

    private static WinningLineRule makeWinningLineRule(Board board) {
        LineEvaluatorImp evaluator = new LineEvaluatorImp(board);
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
        BoardView printer = makeBoardPrinter(board);
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
