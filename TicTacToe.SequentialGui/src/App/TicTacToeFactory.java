package App;

import Board.Board;
import Board.HashingBoard.HashingBoard;
import Board.Mark;
import Core.BoardRenderer.BoardRenderer;
import Core.BoardRenderer.WinningLineProvider;
import Core.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Core.GameEvaluation.GameEvaluator.GameEvaluator;
import Core.GameEvaluation.GameEvaluator.LineEvaluator;
import Core.GameEvaluation.GameEvaluator.LineProvider;
import Core.GameEvaluation.GameEvaluator.WinnerProvider;
import Core.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Core.GameImp.Game;
import Core.GameImp.GameImp;
import Core.GameImp.GameLoop;
import Core.GameLoopImp.GameLoopImp;
import Core.GameLoopImp.GameOverRule;
import Core.GameLoopImp.Renderer;
import Core.GameLoopImp.Turn;
import Core.GameOverRules.CompositeGameOverRule.CompositeGameOverRule;
import Core.GameOverRules.NumberOfMovesRule.NumberOfMovesRule;
import Core.GameOverRules.WinnerRule.HasWinnerProvider;
import Core.GameOverRules.WinnerRule.WinnerRule;
import Core.InputGenerators.AlertingInputGenerator.AlertingInputGenerator;
import Core.InputGenerators.AlertingInputGenerator.InputValidator;
import Core.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputAlerter;
import Core.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputRule;
import Core.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputValidatorImp;
import Core.InputGenerators.AlertingInputGenerator.InputValidatorImp.RuleChoosingInputAlerter.RuleChoosingInputAlerter;
import Core.InputGenerators.RandomInputGenerator.RandomInputGenerator;
import Core.InputGenerators.ValidatingInputGenerator.ValidatingInputGenerator;
import Core.InputRules.CompositeInputRule.CompositeInputRule;
import Core.InputRules.FieldExistsRule.FieldExistsRule;
import Core.InputRules.FieldIsEmptyRule.FieldIsEmptyRule;
import Core.Messages.AlertingMessages;
import Core.Players.InputGenerator;
import Core.Players.PlayerContext;
import Core.TwoPlayerTurn.Player;
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
import Messaging.Player.MessagingPlayer.MessagingPlayer;
import Messaging.Player.MessagingPlayer.PlayerMessenger;
import Messaging.Player.PlayerMessengerImp.HumbleMarkedFieldMessageProviderImp;
import Messaging.Player.PlayerMessengerImp.PlayerMessengerImp;
import Messaging.Turn.MappingTurnMessenger.MappingTurnMessenger;
import Messaging.Turn.MessagingTurn.MessagingTwoPlayerTurn;
import Messaging.Turn.MessagingTurn.TurnMessenger;
import View.*;

public class TicTacToeFactory {

    private final String humanWinMessage = OnePlayerModeMessages.humanWinMessage;
    private final String computerWinMessage = OnePlayerModeMessages.computerWinMessage;
    private final String drawMessage = OnePlayerModeMessages.drawMessage;
    private final String salutation = OnePlayerModeMessages.salutation;
    private final String humanTurnMessage = OnePlayerModeMessages.humanTurnMessage;
    private final String computerTurnMessage = OnePlayerModeMessages.computerTurnMessage;

    private FXMessenger messenger;
    private FXBoardView boardView;
    private FXInputView inputView;
    public FXShell shell;

    public Game makeGame() {
        Board board = makeBoard();
        MarkToStringMapper mapper = makeMarkToStringMapper();

        boardView = new FXBoardView(200, board, mapper);
        inputView = new FXInputView(200);
        messenger = new FXMessenger(450);

        shell = new FXShell(boardView, inputView, messenger);

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
        InputAlerter existsAlerter = makeFXInputAlerter(AlertingMessages.inputDoesNotExist);
        InputAlerter isFreeAlerter = makeFXInputAlerter(AlertingMessages.inputAlreadyMarked);

        RuleChoosingInputAlerter alerter = new RuleChoosingInputAlerter();
        alerter.register(existsRule, existsAlerter);
        alerter.register(isFreeRule, isFreeAlerter);

        return alerter;
    }

    private FXInputAlerter makeFXInputAlerter(String inputDoesNotExist) {
        return new FXInputAlerter(inputDoesNotExist);
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
