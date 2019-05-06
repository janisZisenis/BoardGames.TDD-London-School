package App;


import Bussiness.BoardRenderer.BoardRenderer;
import Bussiness.BoardRenderer.BoardRenderingView;
import Domain.Board.Board;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.Data.Mark;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Domain.GameEvaluation.GameEvaluator.Api.WinnerProvider;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Domain.GameEvaluation.GameEvaluator.GameEvaluator;
import Domain.GameEvaluation.GameEvaluator.LineEvaluator;
import Domain.GameEvaluation.GameEvaluator.LineProvider;
import Domain.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Domain.InputGeneration.InputValidators.FieldExistsValidator.FieldExistsValidator;
import Domain.InputGeneration.InputValidators.FieldIsEmptyValidator.FieldIsEmptyValidator;
import Domain.InputGeneration.MinimaxInputGenerator.MinimaxInputGenerator;
import Domain.InputGeneration.RandomInputGenerator.RandomInputGenerator;
import Domain.NumberOfMovesRule.NumberOfMovesRule;
import Domain.Players.PlayerContext;
import Gaming.GameImp.Game;
import Gaming.GameImp.GameImp;
import Gaming.GameImp.GameLoop;
import Gaming.GameLoopImp.GameLoopImp;
import Gaming.GameLoopImp.GameOverRule;
import Gaming.GameLoopImp.Renderer;
import Gaming.GameLoopImp.Turn;
import Gaming.GameOverRules.CompositeGameOverRule.CompositeGameOverRule;
import Gaming.GameOverRules.WinnerRule.HasWinnerProvider;
import Gaming.GameOverRules.WinnerRule.WinnerRule;
import Gaming.TwoPlayerTurn.Player;
import InputGeneration.CompositeInputValidator.CompositeInputValidator;
import InputGeneration.InputGenerator;
import InputGeneration.InputGenerators.AlertingInputGenerator.AlertingInputGenerator;
import InputGeneration.InputGenerators.AlertingInputGenerator.AlertingInputValidator;
import InputGeneration.InputGenerators.ValidatingInputGenerator.ValidatingInputGenerator;
import InputGeneration.InputValidatorImp.InputAlerter;
import InputGeneration.InputValidatorImp.InputValidator;
import InputGeneration.InputValidatorImp.AlertingInputValidatorImp;
import InputGeneration.MappingInputAlerter.MappingInputAlerter;
import Mapping.MarkToStringMapper;
import Mapping.MarkToStringMappers.MarkToMessageMapper;
import Mapping.MarkToStringMappers.MarkToXOMapper;
import Mapping.ObjectToStringMapper;
import Mapping.ObjectToStringMappers.ObjectToMessageMapper;
import Messages.AlertingMessages;
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
    private BoardRenderingView boardView;
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
        InputGenerator computerGenerator = makeComputerInputGenerator(board, m);
        return makePlayer(board, computerGenerator, m);
    }

    private Player makePlayer(Board board, InputGenerator generator, Mark m) {
        PlayerContext context = new PlayerContext(generator, board, m);
        PlayerMessenger messenger = makePlayerMessenger();
        return new MessagingPlayer(context, messenger);
    }

    private InputGenerator makeComputerInputGenerator(Board board, Mark m) {
        InputValidator inputValidator = makeInputValidator(board);
        InputGenerator randomGenerator = makeMinimaxInputGenerator(board, m);
        return new ValidatingInputGenerator(randomGenerator, inputValidator);
    }

    private InputGenerator makeMinimaxInputGenerator(Board board, Mark m) {
        return new MinimaxInputGenerator(board, m);
    }

    private RandomInputGenerator makeRandomInputGenerator() {
        return new RandomInputGenerator();
    }

    private InputGenerator makeHumanInputGenerator(Board board) {
        AlertingInputValidator validator = makeAlertingInputValidator(board);
        InputGenerator consoleGenerator = inputView;
        return new AlertingInputGenerator(consoleGenerator, validator);
    }

    private InputValidator makeInputValidator(Board board) {
        InputValidator existsValidator = makeFieldExistsValidator();
        InputValidator isFreeValidator = makeFieldIsEmptyValidator(board);

        CompositeInputValidator inputValidator = new CompositeInputValidator();
        inputValidator.add(existsValidator);
        inputValidator.add(isFreeValidator);

        return inputValidator;
    }

    private FieldExistsValidator makeFieldExistsValidator() {
        return new FieldExistsValidator();
    }

    private InputAlerter makeInputAlerter(Board board) {
        InputValidator existsValidator = makeFieldExistsValidator();
        InputValidator isFreeValidator = makeFieldIsEmptyValidator(board);
        InputAlerter existsAlerter = makeConsoleInputAlerter(AlertingMessages.inputDoesNotExist);
        InputAlerter isFreeAlerter = makeConsoleInputAlerter(AlertingMessages.inputAlreadyMarked);

        MappingInputAlerter alerter = new MappingInputAlerter();
        alerter.register(existsValidator, existsAlerter);
        alerter.register(isFreeValidator, isFreeAlerter);

        return alerter;
    }

    private ConsoleInputAlerter makeConsoleInputAlerter(String inputDoesNotExist) {
        return new ConsoleInputAlerter(inputDoesNotExist);
    }

    private FieldIsEmptyValidator makeFieldIsEmptyValidator(Board board) {
        return new FieldIsEmptyValidator(board);
    }

    private AlertingInputValidator makeAlertingInputValidator(Board board) {
        InputValidator validator = makeInputValidator(board);
        InputAlerter alerter = makeInputAlerter(board);
        return new AlertingInputValidatorImp(validator, alerter);
    }

}
