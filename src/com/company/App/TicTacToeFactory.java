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
import com.company.TicTacToe.GameOverRules.NumberOfMovesRule.NumberOfMovesRule;
import com.company.TicTacToe.GameOverRules.WinningLineRule.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import com.company.TicTacToe.GameOverRules.WinningLineRule.WinningLineRule;
import com.company.TicTacToe.InputRules.FieldExistsRule.FieldExistsRule;
import com.company.TicTacToe.InputRules.FieldIsEmptyRule.FieldIsEmptyRule;
import com.company.TicTacToe.PlayerImp.PlayerContext;
import com.company.TicTacToe.PlayerImp.PlayerImp;

public class TicTacToeFactory {

    public ObservableBoard makeDisplayedBoard() {
        ObservableBoard board = makeBoard();
        return board;
    }
    
    public GameLoop makeTicTacToeGameLoop(Board board) {
        Turn turn = makeTicTacToeTurn(board);
        GameOverRule rule = makeTicTacToeGameOverRule(board);
        return new GameLoop(turn, rule);
    }

    private Turn makeTicTacToeTurn(Board board) {
        Player john = makeTicTacToePlayer(board, Mark.John);
        Player haley = makeTicTacToePlayer(board, Mark.Haley);

        return new TwoPlayerTurn(john, haley);
    }

    private Player makeTicTacToePlayer(Board board, Mark mark) {
        InputGenerator generator = makeVerboseTicTacToeInputGenerator(board);
        PlayerContext context = new PlayerContext(generator, board, mark);

        return new PlayerImp(context);
    }

    private InputGenerator makeVerboseTicTacToeInputGenerator(Board board) {
        InputReferee referee = makeTicTacToeInputReferee(board);
        InputGenerator generator = makeConsoleGenerator();

        return new VerboseValidatingInputGenerator(generator, referee);
    }

    private InputReferee makeTicTacToeInputReferee(Board board) {
        InputAlerter alerter = makeTicTacToeInputAlerter(board);
        InputRule rule = makeTicTacToeInputRule(board);

        return new InputRefereeImp(rule, alerter);
    }

    private InputAlerter makeTicTacToeInputAlerter(Board board) {
        InputRule existsRule = makeTicTacToeFieldExistsRule();
        InputAlerter existsAlerter = makeTicTacToeFieldExistsAlerter();
        InputRule isFreeRule = makeTicTacToeFieldIsEmptyRule(board);
        InputAlerter isFreeAlerter = makeTicTacToeFieldIsEmptyAlerter();

        RuleChoosingInputAlerter choosing = new RuleChoosingInputAlerter();
        choosing.register(existsRule, existsAlerter);
        choosing.register(isFreeRule, isFreeAlerter);
        return choosing;
    }

    private InputRule makeTicTacToeFieldExistsRule() {
        return new FieldExistsRule();
    }

    private InputAlerter makeTicTacToeFieldExistsAlerter() {
        return new ConsoleInputAlerter(AlertingMessages.inputDoesNotExist);
    }

    private InputRule makeTicTacToeFieldIsEmptyRule(Board board) {
        return new FieldIsEmptyRule(board);
    }

    private InputAlerter makeTicTacToeFieldIsEmptyAlerter() {
        return new ConsoleInputAlerter(AlertingMessages.inputAlreadyMarked);
    }

    private InputRule makeTicTacToeInputRule(Board board) {
        InputRule existsRule = makeTicTacToeFieldExistsRule();
        InputRule isFreeRule = makeTicTacToeFieldIsEmptyRule(board);

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
        return new WinningLineRule(provider, evaluator);
    }
    
    private ObservableBoard makeBoard() {
        Board hashing = new HashingBoard();
        return new ObservableBoard(hashing);
    }

}
