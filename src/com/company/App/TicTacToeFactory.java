package com.company.App;

import com.company.CLI.Core.InputGeneration.ConsoleInputAlerter;
import com.company.CLI.Core.InputGeneration.ConsoleInputGenerator;
import com.company.CLI.TicTacToe.View.AlertingMessages;
import com.company.Core.GameLoop.GameLoop;
import com.company.Core.GameLoop.Turn;
import com.company.Core.GameLoop.TwoPlayerTurn.Player;
import com.company.Core.GameLoop.TwoPlayerTurn.TwoPlayerTurn;
import com.company.Core.GameOverRules.CompositeGameOverRule;
import com.company.Core.GameOverRules.GameOverRule;
import com.company.Core.InputGeneration.InputGenerator;
import com.company.Core.InputGeneration.InputRule.CompositeInputRule.CompositeInputRule;
import com.company.Core.InputGeneration.InputRule.InputRule;
import com.company.Core.InputGeneration.VerboseValidatingInputGenerator.InputReferee;
import com.company.Core.InputGeneration.VerboseValidatingInputGenerator.InputRefereeImp.InputAlerter;
import com.company.Core.InputGeneration.VerboseValidatingInputGenerator.InputRefereeImp.InputRefereeImp;
import com.company.Core.InputGeneration.VerboseValidatingInputGenerator.InputRefereeImp.RuleChoosingInputAlerter.RuleChoosingInputAlerter;
import com.company.Core.InputGeneration.VerboseValidatingInputGenerator.VerboseValidatingInputGenerator;
import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.HashingBoard.HashingBoard;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Board.ObservableBoard.ObservableBoard;
import com.company.TicTacToe.BoardPresenter.WinningLineProvider;
import com.company.TicTacToe.GameOverRules.NumberOfMovesRule.NumberOfMovesRule;
import com.company.TicTacToe.GameOverRules.WinnerRule.WinnerRule;
import com.company.TicTacToe.InputRules.FieldExistsRule.FieldExistsRule;
import com.company.TicTacToe.InputRules.FieldIsEmptyRule.FieldIsEmptyRule;
import com.company.TicTacToe.TicTacToePlayer.PlayerContext;
import com.company.TicTacToe.TicTacToePlayer.TicTacToePlayer;
import com.company.TicTacToe.GameEvaluator.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import com.company.TicTacToe.GameEvaluator.LineEvaluator;
import com.company.TicTacToe.GameEvaluator.LineProvider;
import com.company.TicTacToe.GameEvaluator.GameEvaluator;

public class TicTacToeFactory {

    public ObservableBoard makeDisplayedBoard() {
        ObservableBoard board = makeObservableBoard();
        return board;
    }

    public WinningLineProvider makeWinningLineProvider(Board board) {
        LineProvider provider = new TicTacToeLineProvider();
        LineEvaluator evaluator = new EquallyMarkedLineEvaluator(board);
        return new GameEvaluator(provider, evaluator);
    }

    public GameLoop makeGameLoop(Board board) {
        Turn turn = makeTurn(board);
        GameOverRule rule = makeTicTacToeGameOverRule(board);
        return new GameLoop(turn, rule);
    }

    private Turn makeTurn(Board board) {
        Player john = makePlayer(board, Mark.John);
        Player haley = makePlayer(board, Mark.Haley);

        return new TwoPlayerTurn(john, haley);
    }

    private Player makePlayer(Board board, Mark mark) {
        InputGenerator generator = makeVerboseInputGenerator(board);
        PlayerContext context = new PlayerContext(generator, board, mark);

        return new TicTacToePlayer(context);
    }

    private InputGenerator makeVerboseInputGenerator(Board board) {
        InputReferee referee = makeInputReferee(board);
        InputGenerator generator = makeConsoleGenerator();

        return new VerboseValidatingInputGenerator(generator, referee);
    }

    private InputReferee makeInputReferee(Board board) {
        InputAlerter alerter = makeInputAlerter(board);
        InputRule rule = makeInputRule(board);

        return new InputRefereeImp(rule, alerter);
    }

    private InputAlerter makeInputAlerter(Board board) {
        InputRule existsRule = makeFieldExistsRule();
        InputAlerter existsAlerter = makeFieldExistsAlerter();
        InputRule isFreeRule = makeFieldIsEmptyRule(board);
        InputAlerter isFreeAlerter = makeFieldIsEmptyAlerter();

        RuleChoosingInputAlerter choosing = new RuleChoosingInputAlerter();
        choosing.register(existsRule, existsAlerter);
        choosing.register(isFreeRule, isFreeAlerter);
        return choosing;
    }

    private InputRule makeFieldExistsRule() {
        return new FieldExistsRule();
    }

    private InputAlerter makeFieldExistsAlerter() {
        return new ConsoleInputAlerter(AlertingMessages.inputDoesNotExist);
    }

    private InputRule makeFieldIsEmptyRule(Board board) {
        return new FieldIsEmptyRule(board);
    }

    private InputAlerter makeFieldIsEmptyAlerter() {
        return new ConsoleInputAlerter(AlertingMessages.inputAlreadyMarked);
    }

    private InputRule makeInputRule(Board board) {
        InputRule existsRule = makeFieldExistsRule();
        InputRule isFreeRule = makeFieldIsEmptyRule(board);

        CompositeInputRule composite = new CompositeInputRule();
        composite.add(existsRule);
        composite.add(isFreeRule);

        return composite;
    }

    private InputGenerator makeConsoleGenerator() {
        return new ConsoleInputGenerator();
    }



    private GameOverRule makeTicTacToeGameOverRule(Board board) {
        GameOverRule numberOfMovesRule = makeNumberOfMovesRule(board);
        GameOverRule winningLineRule = makeWinningLineRule(board);

        CompositeGameOverRule rule = new CompositeGameOverRule();
        rule.add(numberOfMovesRule);
        rule.add(winningLineRule);

        return rule;
    }

    private GameOverRule makeNumberOfMovesRule(Board board) {
        return new NumberOfMovesRule(board);
    }

    public GameOverRule makeWinningLineRule(Board board) {
        EquallyMarkedLineEvaluator evaluator = new EquallyMarkedLineEvaluator(board);
        TicTacToeLineProvider provider = new TicTacToeLineProvider();
        GameEvaluator winningLineProvider = new GameEvaluator(provider, evaluator);
        return new WinnerRule(winningLineProvider);
    }
    
    private ObservableBoard makeObservableBoard() {
        Board hashing = new HashingBoard();
        return new ObservableBoard(hashing);
    }

}
