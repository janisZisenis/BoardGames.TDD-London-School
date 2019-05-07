package App;


import Domain.Board.Board;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.Data.Mark;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Domain.GameEvaluation.GameEvaluator.GameEvaluator;
import Domain.GameEvaluation.GameEvaluator.LineEvaluator;
import Domain.GameEvaluation.GameEvaluator.LineProvider;
import Domain.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Domain.InputFieldGeneratorAdapter.InputFieldGeneratorAdapter;
import Domain.InputGeneration.InputValidators.FieldExistsValidator.FieldExistsValidator;
import Domain.InputGeneration.InputValidators.FieldIsEmptyValidator.FieldIsEmptyValidator;
import Domain.InputGeneration.MinimaxInputGenerator.MinimaxInputGenerator;
import Domain.NumberOfMovesRule.NumberOfMovesRule;
import Domain.Turn.FieldGenerator;
import Domain.Turn.TicTacToeTurn;
import InputGeneration.InputGenerator;
import InputGeneration.ValidInputGenerator.InputValidator;
import Mapping.MarkToStringMappers.MarkToXOMapper;
import Mapping.ObjectToStringMappers.DefaultObjectToStringMapper;
import Messages.AlertingMessages;
import Messages.OnePlayerModeMessages;
import SequentialGaming.DelegatingGame.Renderer;
import SequentialGaming.Factory;
import SequentialGaming.GameLoop.Game;
import SequentialGaming.GameLoop.GameLoop;
import SequentialGaming.GameOverRules.CompositeGameOverRule.CompositeGameOverRule;
import SequentialGaming.MultiTurn.MultiTurn;
import SequentialGaming.MultiTurn.MultiTurnMessenger;
import SequentialRendering.BoardRenderer.BoardRenderer;
import View.ConsoleBoardView;
import View.ConsoleInputAlerter;
import View.ConsoleInputGenerator;
import View.ConsoleMessenger;

public class Main {

    public static void main(String[] args) {
        Board board = new HashingBoard();

        ConsoleInputGenerator consoleGenerator = new ConsoleInputGenerator();
        ConsoleInputAlerter existsAlerter = new ConsoleInputAlerter(AlertingMessages.inputDoesNotExist);
        ConsoleInputAlerter alreadyMarkedAlerter = new ConsoleInputAlerter(AlertingMessages.inputAlreadyMarked);
        ConsoleBoardView view = new ConsoleBoardView(board, new MarkToXOMapper());
        ConsoleMessenger messenger = new ConsoleMessenger();

        LineProvider lineProvider = new HumbleLineProvider();
        LineEvaluator lineEvaluator = new EquallyMarkedLineEvaluator(board);
        GameEvaluator gameEvaluator = new GameEvaluator(lineProvider, lineEvaluator);

        InputValidator existsValidator = new FieldExistsValidator();
        InputValidator isEmptyValidator = new FieldIsEmptyValidator(board);

        InputGenerator humanGenerator = InputGeneration.Factory.makeAlertingInputGenerator(consoleGenerator, existsValidator, existsAlerter);
        humanGenerator = InputGeneration.Factory.makeAlertingInputGenerator(humanGenerator, isEmptyValidator, alreadyMarkedAlerter);
        FieldGenerator humanGeneratorAdapter = new InputFieldGeneratorAdapter(humanGenerator);

        InputGenerator minimaxGenerator = new MinimaxInputGenerator(board, Mark.Haley);
        InputGenerator computerGenerator = InputGeneration.Factory.makeAlertingInputGenerator(minimaxGenerator, existsValidator, existsAlerter);
        computerGenerator = InputGeneration.Factory.makeAlertingInputGenerator(computerGenerator, isEmptyValidator, alreadyMarkedAlerter);
        InputFieldGeneratorAdapter computerGeneratorAdapter = new InputFieldGeneratorAdapter(computerGenerator);

        TicTacToeTurn john = new TicTacToeTurn(Mark.John, board, humanGeneratorAdapter);
        TicTacToeTurn haley = new TicTacToeTurn(Mark.Haley, board, computerGeneratorAdapter);

        Renderer renderer = new BoardRenderer(view, gameEvaluator);

        DefaultObjectToStringMapper turnMapper = new DefaultObjectToStringMapper("Next turn!");
        turnMapper.register(john, OnePlayerModeMessages.humanTurnMessage);
        turnMapper.register(haley, OnePlayerModeMessages.computerTurnMessage);
        MultiTurnMessenger turnMessenger = Messaging.Factory.makeMappingMultiTurnMessenger(turnMapper, messenger);

        CompositeGameOverRule rule = Factory.makeCompositeGameOverRule();
        rule.add(Factory.makeWinnerRule(gameEvaluator));
        rule.add(new NumberOfMovesRule(board));
        MultiTurn turn = Factory.makeMessagingMultiTurn(john, turnMessenger);
        turn.add(haley);
        Game game = Factory.makeGame(rule, turn, renderer);
        GameLoop loop = Factory.makeGameLoop(game);

        renderer.render();
        loop.run();
    }

}
