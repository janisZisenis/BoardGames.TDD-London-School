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
import View.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        Board board = new HashingBoard();

        FXInputView fxGenerator = new FXInputView(200);
        FXInputAlerter fxExistsAlerter = new FXInputAlerter(AlertingMessages.inputDoesNotExist);
        FXInputAlerter fxAlreadyMarkedAlerter = new FXInputAlerter(AlertingMessages.inputAlreadyMarked);
        FXBoardView fxBoard = new FXBoardView(200, board, new MarkToXOMapper());
        FXMessenger fxMessenger = new FXMessenger(435);
        FXShell fxShell = new FXShell(fxBoard, fxGenerator, fxMessenger);

        LineProvider lineProvider = new HumbleLineProvider();
        LineEvaluator lineEvaluator = new EquallyMarkedLineEvaluator(board);
        GameEvaluator gameEvaluator = new GameEvaluator(lineProvider, lineEvaluator);

        InputValidator existsValidator = new FieldExistsValidator();
        InputValidator isEmptyValidator = new FieldIsEmptyValidator(board);

        InputGenerator humanGenerator = InputGeneration.Factory.makeAlertingInputGenerator(fxGenerator, existsValidator, fxExistsAlerter);
        humanGenerator = InputGeneration.Factory.makeAlertingInputGenerator(humanGenerator, isEmptyValidator, fxAlreadyMarkedAlerter);
        FieldGenerator humanGeneratorAdapter = new InputFieldGeneratorAdapter(humanGenerator);

        InputGenerator minimaxGenerator = new MinimaxInputGenerator(board, Mark.Haley);
        InputGenerator computerGenerator = InputGeneration.Factory.makeAlertingInputGenerator(minimaxGenerator, existsValidator, fxExistsAlerter);
        computerGenerator = InputGeneration.Factory.makeAlertingInputGenerator(computerGenerator, isEmptyValidator, fxAlreadyMarkedAlerter);
        InputFieldGeneratorAdapter computerGeneratorAdapter = new InputFieldGeneratorAdapter(computerGenerator);

        TicTacToeTurn john = new TicTacToeTurn(Mark.John, board, humanGeneratorAdapter);
        TicTacToeTurn haley = new TicTacToeTurn(Mark.Haley, board, computerGeneratorAdapter);

        Renderer renderer = new BoardRenderer(fxBoard, gameEvaluator);

        DefaultObjectToStringMapper turnMapper = new DefaultObjectToStringMapper(OnePlayerModeMessages.defaultTurnMessage);
        turnMapper.register(john, OnePlayerModeMessages.humanTurnMessage);
        turnMapper.register(haley, OnePlayerModeMessages.computerTurnMessage);
        MultiTurnMessenger turnMessenger = Messaging.Factory.makeMappingMultiTurnMessenger(turnMapper, fxMessenger);

        CompositeGameOverRule rule = Factory.makeCompositeGameOverRule();
        rule.add(Factory.makeWinnerRule(gameEvaluator));
        rule.add(new NumberOfMovesRule(board));
        MultiTurn turn = Factory.makeMessagingMultiTurn(john, turnMessenger);
        turn.add(haley);
        Game game = Factory.makeGame(rule, turn, renderer);
        GameLoop loop = Factory.makeGameLoop(game);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(fxShell));
        primaryStage.setResizable(false);
        primaryStage.show();

        Thread t = new Thread() {
            public void run(){
            renderer.render();
            loop.run();
            }
        };
        t.start();

    }
}
