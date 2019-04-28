package App;


import Lib.CLI.View.InputGenerators.ConsoleInputAlerter;
import Lib.CLI.View.InputGenerators.ConsoleInputGenerator;
import Lib.CLI.View.InputGenerators.ConsoleTurnMessenger;
import Lib.CLI.View.TicTacToeView.AlertingMessages;
import Lib.CLI.View.TicTacToeView.ConsoleBoardView;
import Lib.CLI.View.TicTacToeView.ConsoleGameMessenger;
import Lib.Data.Mark;
import Lib.Model.Board.Board;
import Lib.Model.Board.HashingBoard.HashingBoard;
import Lib.Model.BoardRenderer.BoardRenderer;
import Lib.Model.BoardRenderer.WinningLineProvider;
import Lib.Model.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Lib.Model.GameEvaluation.GameEvaluator.GameEvaluator;
import Lib.Model.GameEvaluation.GameEvaluator.LineEvaluator;
import Lib.Model.GameEvaluation.GameEvaluator.LineProvider;
import Lib.Model.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Lib.Model.GameLoopImp.GameLoopImp;
import Lib.Model.GameLoopImp.GameOverRule;
import Lib.Model.GameLoopImp.Renderer;
import Lib.Model.GameLoopImp.Turn;
import Lib.Model.GameOverRules.CompositeGameOverRule.CompositeGameOverRule;
import Lib.Model.GameOverRules.NumberOfMovesRule.NumberOfMovesRule;
import Lib.Model.GameOverRules.WinnerRule.HasWinnerProvider;
import Lib.Model.GameOverRules.WinnerRule.WinnerRule;
import Lib.Model.Games.GameImp.GameImp;
import Lib.Model.Games.GameImp.GameLoop;
import Lib.Model.Games.MessagingGame.Game;
import Lib.Model.Games.MessagingGame.GameMessenger;
import Lib.Model.Games.MessagingGame.MessagingGame;
import Lib.Model.InputGenerators.AlertingInputGenerator.AlertingInputGenerator;
import Lib.Model.InputGenerators.AlertingInputGenerator.InputValidator;
import Lib.Model.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputAlerter;
import Lib.Model.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputRule;
import Lib.Model.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputValidatorImp;
import Lib.Model.InputGenerators.AlertingInputGenerator.InputValidatorImp.RuleChoosingInputAlerter.RuleChoosingInputAlerter;
import Lib.Model.InputGenerators.RandomInputGenerator.RandomInputGenerator;
import Lib.Model.InputGenerators.ValidatingInputGenerator.ValidatingInputGenerator;
import Lib.Model.InputRules.CompositeInputRule.CompositeInputRule;
import Lib.Model.InputRules.FieldExistsRule.FieldExistsRule;
import Lib.Model.InputRules.FieldIsEmptyRule.FieldIsEmptyRule;
import Lib.Model.Players.InputGenerator;
import Lib.Model.Players.PlayerContext;
import Lib.Model.Players.PlayerImp;
import Lib.Model.TwoPlayerTurn.MessagingTwoPlayerTurn.MessagingTwoPlayerTurn;
import Lib.Model.TwoPlayerTurn.Player;
import Lib.Presentation.LeaveTaker.WinnerProvider;
import Lib.Presentation.MarkToStringMapper.MarkToStringMapper;
import Lib.Presentation.MarkToStringMapper.MarkToXOMapper;

public class TicTacToeFactory {

    public Game makeGame() {
        Board board = makeBoard();

        Renderer renderer = makeRenderer(board);
        GameLoop loop = makeGameLoop(board);
        Game game = new GameImp(renderer, loop);
        MarkToStringMapper mapper = makeMarkToStringMapper();
        WinnerProvider provider = makeGameEvaluator(board);
        GameMessenger messenger = new ConsoleGameMessenger(provider, mapper);
        return new MessagingGame(game, messenger);
    }

    private HashingBoard makeBoard() {
        return new HashingBoard();
    }

    private GameLoop makeGameLoop(Board board) {
        GameOverRule rule = makeGameOverRule(board);
        Turn turn = makeTurn(board);
        Renderer renderer = makeRenderer(board);
        return new GameLoopImp(rule, turn, renderer);
    }

    private Renderer makeRenderer(Board board) {
        ConsoleBoardView view = makeConsoleBoardView(board);
        WinningLineProvider provider = makeWinningLineProvider(board);
        return new BoardRenderer(view, provider);
    }

    private ConsoleBoardView makeConsoleBoardView(Board board) {
        MarkToStringMapper mapper = makeMarkToStringMapper();
        return new ConsoleBoardView(board, mapper);
    }

    private MarkToStringMapper makeMarkToStringMapper() {
        return new MarkToXOMapper();
    }

    private WinningLineProvider makeWinningLineProvider(Board board) {
        return makeGameEvaluator(board);
    }

    private EquallyMarkedLineEvaluator makeLineEvaluator(Board board) {
        return new EquallyMarkedLineEvaluator(board);
    }

    private LineProvider makeLineProvider() {
        return new HumbleLineProvider();
    }

    private GameOverRule makeGameOverRule(Board board) {
        GameOverRule numberOfMovesRule = makeNumberOfMovesRule(board);
        GameOverRule winningLineRule = makeWinnerRule(board);

        CompositeGameOverRule composite = new CompositeGameOverRule();
        composite.add(numberOfMovesRule);
        composite.add(winningLineRule);
        return composite;
    }

    private GameOverRule makeWinnerRule(Board board) {
        HasWinnerProvider winningLineProvider = makeHasWinnerProvider(board);
        return new WinnerRule(winningLineProvider);
    }

    private NumberOfMovesRule makeNumberOfMovesRule(Board board) {
        return new NumberOfMovesRule(board);
    }

    private HasWinnerProvider makeHasWinnerProvider(Board board) {
        return makeGameEvaluator(board);
    }

    private GameEvaluator makeGameEvaluator(Board board) {
        LineProvider provider = makeLineProvider();
        LineEvaluator evaluator = makeLineEvaluator(board);
        return new GameEvaluator(provider, evaluator);
    }


    private Turn makeTurn(Board board) {
        Player john = makeHumanPlayer(board, Mark.John);
        Player haley = makeComputerPlayer(board, Mark.Haley);

        ConsoleTurnMessenger turnMessageView = makeConsoleTurnMessageView();
        turnMessageView.register(john, "X");
        turnMessageView.register(haley, "O");
        return new MessagingTwoPlayerTurn(john, haley, turnMessageView);
    }

    private ConsoleTurnMessenger makeConsoleTurnMessageView() {
        return new ConsoleTurnMessenger();
    }

    private Player makeHumanPlayer(Board board, Mark m) {
        InputGenerator humanGenerator = makeHumanInputGenerator(board);
        return makePlayer(board, humanGenerator, m);
    }

    private Player makeComputerPlayer(Board board, Mark m) {
        InputGenerator computerGenerator = makeComputerInputGenerator(board);
        return makePlayer(board, computerGenerator, m);
    }

    private Player makePlayer(Board board, InputGenerator generator, Mark m) {
        PlayerContext johnContext = new PlayerContext(generator, board, m);
        return new PlayerImp(johnContext);
    }

    private InputGenerator makeComputerInputGenerator(Board board) {
        InputRule inputRule = makeInputRule(board);
        InputGenerator randomGenerator = makeRandomInputGenerator();
        return new ValidatingInputGenerator(randomGenerator, inputRule);
    }

    private RandomInputGenerator makeRandomInputGenerator() {
        return new RandomInputGenerator();
    }

    private InputGenerator makeHumanInputGenerator(Board board) {
        InputValidator validator = makeInputValidator(board);
        InputGenerator consoleGenerator = makeConsoleInputGenerator();
        return new AlertingInputGenerator(consoleGenerator, validator);
    }

    private ConsoleInputGenerator makeConsoleInputGenerator() {
        return new ConsoleInputGenerator();
    }


    private InputRule makeInputRule(Board board) {
        InputRule existsRule = makeFieldExistsRule();
        InputRule isFreeRule = makeFieldIsEmptyRule(board);

        CompositeInputRule inputRule = new CompositeInputRule();
        inputRule.add(existsRule);
        inputRule.add(isFreeRule);

        return inputRule;
    }

    private FieldExistsRule makeFieldExistsRule() {
        return new FieldExistsRule();
    }

    private InputAlerter makeInputAlerter(Board board) {
        InputRule existsRule = makeFieldExistsRule();
        InputRule isFreeRule = makeFieldIsEmptyRule(board);
        InputAlerter existsAlerter = makeConsoleInputAlerter(AlertingMessages.inputDoesNotExist);
        InputAlerter isFreeAlerter = makeConsoleInputAlerter(AlertingMessages.inputAlreadyMarked);

        RuleChoosingInputAlerter alerter = new RuleChoosingInputAlerter();
        alerter.register(existsRule, existsAlerter);
        alerter.register(isFreeRule, isFreeAlerter);

        return alerter;
    }

    private ConsoleInputAlerter makeConsoleInputAlerter(String inputDoesNotExist) {
        return new ConsoleInputAlerter(inputDoesNotExist);
    }

    private FieldIsEmptyRule makeFieldIsEmptyRule(Board board) {
        return new FieldIsEmptyRule(board);
    }

    private InputValidator makeInputValidator(Board board) {
        InputRule rule = makeInputRule(board);
        InputAlerter alerter = makeInputAlerter(board);
        return new InputValidatorImp(rule, alerter);
    }

}
