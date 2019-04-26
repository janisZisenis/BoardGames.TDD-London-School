package com.company.App;

import com.company.CLI.View.InputGenerators.ConsoleInputAlerter;
import com.company.CLI.View.InputGenerators.ConsoleInputGenerator;
import com.company.CLI.View.InputGenerators.ConsoleInputPresenter;
import com.company.CLI.View.TicTacToeView.AlertingMessages;
import com.company.Data.Mark;
import com.company.Model.Board.Board;
import com.company.Model.Board.HashingBoard.HashingBoard;
import com.company.Model.Board.ObservableBoard.ObservableBoard;
import com.company.Model.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import com.company.Model.GameEvaluation.GameEvaluator.GameEvaluator;
import com.company.Model.GameEvaluation.GameEvaluator.LineEvaluator;
import com.company.Model.GameEvaluation.GameEvaluator.LineProvider;
import com.company.Model.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import com.company.Model.GameLoop.GameLoop;
import com.company.Model.GameLoop.GameOverRule;
import com.company.Model.GameLoop.Turn;
import com.company.Model.GameLoop.TwoPlayerTurn.Player;
import com.company.Model.GameLoop.TwoPlayerTurn.TwoPlayerTurn;
import com.company.Model.GameOverRules.CompositeGameOverRule.CompositeGameOverRule;
import com.company.Model.GameOverRules.NumberOfMovesRule.NumberOfMovesRule;
import com.company.Model.GameOverRules.WinnerRule.WinnerRule;
import com.company.Model.InputGenerators.PresentingInputGenerator.InputPresenter;
import com.company.Model.InputGenerators.PresentingInputGenerator.PresentingInputGenerator;
import com.company.Model.InputGenerators.RandomInputGenerator.RandomInputGenerator;
import com.company.Model.InputGenerators.ValidatingInputGenerator.ValidatingInputGenerator;
import com.company.Model.InputGenerators.VerboseValidatingInputGenerator.InputReferee;
import com.company.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp.InputAlerter;
import com.company.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp.InputRefereeImp;
import com.company.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp.InputRule;
import com.company.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp.RuleChoosingInputAlerter.RuleChoosingInputAlerter;
import com.company.Model.InputGenerators.VerboseValidatingInputGenerator.VerboseValidatingInputGenerator;
import com.company.Model.InputRules.CompositeInputRule.CompositeInputRule;
import com.company.Model.InputRules.FieldExistsRule.FieldExistsRule;
import com.company.Model.InputRules.FieldIsEmptyRule.FieldIsEmptyRule;
import com.company.Model.Players.InputGenerator;
import com.company.Model.Players.PlayerContext;
import com.company.Model.Players.PlayerImp;
import com.company.Presentation.BoardPresenter.WinningLineProvider;

public class TicTacToeFactory {

    public ObservableBoard makeDisplayedBoard() {
        ObservableBoard board = makeObservableBoard();
        return board;
    }

    public WinningLineProvider makeWinningLineProvider(Board board) {
        LineProvider provider = new HumbleLineProvider();
        LineEvaluator evaluator = new EquallyMarkedLineEvaluator(board);
        return new GameEvaluator(provider, evaluator);
    }

    public GameLoop makeGameLoop(Board board) {
        Turn turn = makeTurn(board);
        GameOverRule rule = makeTicTacToeGameOverRule(board);
        return new GameLoop(turn, rule);
    }

    private Turn makeTurn(Board board) {
        Player john = makeHumanPlayer(board, Mark.John);
        Player haley = makeComputerPlayer(board, Mark.Haley);

        return new TwoPlayerTurn(john, haley);
    }

    public Player makeHumanPlayer(Board board, Mark mark) {
        InputGenerator generator = makeConsoleInputGenerator(board);
        PlayerContext context = new PlayerContext(generator, board, mark);

        return new PlayerImp(context);
    }

    public Player makeComputerPlayer(Board board, Mark mark) {
        InputGenerator generator = makeComputerInputGenerator(board);
        PlayerContext context = new PlayerContext(generator, board, mark);

        return new PlayerImp(context);
    }

    private InputGenerator makeComputerInputGenerator(Board board) {
        InputGenerator generator = new RandomInputGenerator();
        InputRule rule = makeInputRule(board);
        InputGenerator validating = new ValidatingInputGenerator(generator, rule);
        InputPresenter presenter = new ConsoleInputPresenter();
        return new PresentingInputGenerator(validating, presenter);
    }

    private InputGenerator makeConsoleInputGenerator(Board board) {
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



    public GameOverRule makeTicTacToeGameOverRule(Board board) {
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
        HumbleLineProvider provider = new HumbleLineProvider();
        GameEvaluator winningLineProvider = new GameEvaluator(provider, evaluator);
        return new WinnerRule(winningLineProvider);
    }
    
    private ObservableBoard makeObservableBoard() {
        Board hashing = new HashingBoard();
        return new ObservableBoard(hashing);
    }

}
