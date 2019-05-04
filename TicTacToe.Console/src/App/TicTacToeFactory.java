package App;


import Board.Board;
import Board.HashingBoard.HashingBoard;
import Board.Mark;
import Lib.BoardRenderer.BoardRenderer;
import Lib.BoardRenderer.BoardView;
import Lib.BoardRenderer.WinningLineProvider;
import Lib.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Lib.GameEvaluation.GameEvaluator.GameEvaluator;
import Lib.GameEvaluation.GameEvaluator.LineEvaluator;
import Lib.GameEvaluation.GameEvaluator.LineProvider;
import Lib.GameEvaluation.GameEvaluator.WinnerProvider;
import Lib.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Lib.GameImp.Game;
import Lib.GameImp.GameImp;
import Lib.GameImp.GameLoop;
import Lib.GameLoopImp.GameLoopImp;
import Lib.GameLoopImp.GameOverRule;
import Lib.GameLoopImp.Renderer;
import Lib.GameLoopImp.Turn;
import Lib.GameOverRules.CompositeGameOverRule.CompositeGameOverRule;
import Lib.GameOverRules.NumberOfMovesRule.NumberOfMovesRule;
import Lib.GameOverRules.WinnerRule.HasWinnerProvider;
import Lib.GameOverRules.WinnerRule.WinnerRule;
import Lib.InputGenerators.AlertingInputGenerator.AlertingInputGenerator;
import Lib.InputGenerators.AlertingInputGenerator.InputValidator;
import Lib.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputAlerter;
import Lib.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputRule;
import Lib.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputValidatorImp;
import Lib.InputGenerators.AlertingInputGenerator.InputValidatorImp.RuleChoosingInputAlerter.RuleChoosingInputAlerter;
import Lib.InputGenerators.RandomInputGenerator.RandomInputGenerator;
import Lib.InputGenerators.ValidatingInputGenerator.ValidatingInputGenerator;
import Lib.InputRules.CompositeInputRule.CompositeInputRule;
import Lib.InputRules.FieldExistsRule.FieldExistsRule;
import Lib.InputRules.FieldIsEmptyRule.FieldIsEmptyRule;
import Lib.Messages.AlertingMessages;
import Lib.Players.InputGenerator;
import Lib.Players.PlayerContext;
import Lib.TwoPlayerTurn.Player;
import Mappers.MarkToStringMapper;
import Mappers.MarkToStringMappers.MarkToMessageMapper;
import Mappers.MarkToStringMappers.MarkToXOMapper;
import Mappers.ObjectToStringMapper;
import Mappers.ObjectToStringMappers.ObjectToMessageMapper;
import Messages.OnePlayerModeMessages;
import Messaging.Game.GameMessengerImp.GameMessengerImp;
import Messaging.Game.GameOverMessageProviderImp.GameOverMessageProviderImp;
import Messaging.Game.MessagingGame.GameMessenger;
import Messaging.Game.MessagingGame.MessagingGame;
import Messaging.Game.WinnerMessageProviderImp.WinnerMessageProviderImp;
import Messaging.Messenger;
import Messaging.Player.MessagingPlayer.MessagingPlayer;
import Messaging.Player.MessagingPlayer.PlayerMessenger;
import Messaging.Player.PlayerMessengerImp.HumbleMarkedFieldMessageProviderImp;
import Messaging.Player.PlayerMessengerImp.PlayerMessengerImp;
import Messaging.Turn.MappingTurnMessenger.MappingTurnMessenger;
import Messaging.Turn.MessagingTurn.MessagingTwoPlayerTurn;
import Messaging.Turn.MessagingTurn.TurnMessenger;
import View.ConsoleBoardView;
import View.ConsoleInputAlerter;
import View.ConsoleInputGenerator;
import View.ConsoleMessenger;

public class TicTacToeFactory {

    private final String humanWinMessage = OnePlayerModeMessages.humanWinMessage;
    private final String computerWinMessage = OnePlayerModeMessages.computerWinMessage;
    private final String drawMessage = OnePlayerModeMessages.drawMessage;
    private final String salutation = OnePlayerModeMessages.salutation;
    private final String humanTurnMessage = OnePlayerModeMessages.humanTurnMessage;
    private final String computerTurnMessage = OnePlayerModeMessages.computerTurnMessage;

    private Messenger messenger;
    private BoardView boardView;
    private InputGenerator inputView;

    public Game makeGame() {
        Board board = makeBoard();
        MarkToStringMapper mapper = makeMarkToStringMapper();

        boardView = new ConsoleBoardView(board, mapper);
        inputView = new ConsoleInputGenerator();
        messenger = new ConsoleMessenger();

        Renderer renderer = makeRenderer(board);
        GameLoop loop = makeGameLoop(board);
        Game game = new GameImp(renderer, loop);

        GameMessenger gameMessenger = makeGameMessenger(board);
        return new MessagingGame(game, gameMessenger);
    }

    private PlayerMessenger makePlayerMessenger() {
        HumbleMarkedFieldMessageProviderImp fieldProvider = new HumbleMarkedFieldMessageProviderImp();
        return new PlayerMessengerImp(messenger, fieldProvider);
    }

    private TurnMessenger makeTurnMessenger(ObjectToStringMapper mapper) {
        return new MappingTurnMessenger(messenger, mapper);
    }

    private GameMessenger makeGameMessenger(Board board) {
        WinnerProvider provider = makeGameEvaluator(board);
        MarkToStringMapper messageMapper = new MarkToMessageMapper(humanWinMessage, computerWinMessage);
        WinnerMessageProviderImp winnerMessageProvider = new WinnerMessageProviderImp(provider, messageMapper);
        GameOverMessageProviderImp goMessageProvider = new GameOverMessageProviderImp(winnerMessageProvider, drawMessage);
        return new GameMessengerImp(messenger, goMessageProvider, salutation);
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
        WinningLineProvider provider = makeWinningLineProvider(board);
        return new BoardRenderer(boardView, provider);
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

        ObjectToMessageMapper objectMapper = new ObjectToMessageMapper();
        objectMapper.register(john, humanTurnMessage);
        objectMapper.register(haley, computerTurnMessage);
        TurnMessenger messenger = makeTurnMessenger(objectMapper);

        return new MessagingTwoPlayerTurn(john, haley, messenger);
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
        PlayerContext context = new PlayerContext(generator, board, m);
        PlayerMessenger messenger = makePlayerMessenger();
        return new MessagingPlayer(context, messenger);
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
        InputGenerator consoleGenerator = inputView;
        return new AlertingInputGenerator(consoleGenerator, validator);
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
