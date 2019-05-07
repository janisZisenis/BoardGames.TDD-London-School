package App;

import Domain.Board.Board;
import Domain.Data.Mark;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Domain.InputGeneration.InputValidators.FieldExistsValidator.FieldExistsValidator;
import Domain.InputGeneration.InputValidators.FieldIsEmptyValidator.FieldIsEmptyValidator;
import Domain.InputGeneration.MinimaxInputGenerator.MinimaxInputGenerator;
import Domain.TurnCreationContext;
import InputGeneration.ValidInputGenerator.InputAlerter;
import InputGeneration.ValidInputGenerator.InputValidator;
import Mapping.MarkToStringMappers.MarkToXOMapper;
import Mapping.ObjectToStringMappers.DefaultObjectToStringMapper;
import Messages.AlertingMessages;
import Messages.OnePlayerModeMessages;
import SequentialGaming.DelegatingGame.GameOverRule;
import SequentialGaming.DelegatingGame.Renderer;
import SequentialGaming.DelegatingGame.Turn;
import SequentialGaming.Factory;
import SequentialGaming.GameLoopImp.Game;
import SequentialGaming.MessagingGameLoop.GameLoop;
import SequentialGaming.MessagingGameLoop.GameLoopMessenger;
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
        Board board = Domain.Factory.makeBoard();

        FXInputView fxGenerator = new FXInputView(200);
        FXBoardView fxBoard = new FXBoardView(200, board, new MarkToXOMapper());
        FXMessenger fxMessenger = new FXMessenger(435);
        FXShell fxShell = new FXShell(fxBoard, fxGenerator, fxMessenger);

        InputValidator existsValidator = new FieldExistsValidator();
        InputAlerter fxExistsAlerter = new FXInputAlerter(AlertingMessages.inputDoesNotExist);
        InputValidator isEmptyValidator = new FieldIsEmptyValidator(board);
        InputAlerter fxAlreadyMarkedAlerter = new FXInputAlerter(AlertingMessages.inputAlreadyMarked);

        Turn john = Domain.Factory.makeTicTacToeTurn(
            new TurnCreationContext(
                Mark.John,
                board,
                fxGenerator,
                fxExistsAlerter,
                existsValidator,
                fxAlreadyMarkedAlerter,
                isEmptyValidator
            )
        );

        Turn haley = Domain.Factory.makeTicTacToeTurn(
            new TurnCreationContext(
                Mark.Haley,
                board,
                new MinimaxInputGenerator(board, Mark.Haley),
                fxExistsAlerter,
                existsValidator,
                fxAlreadyMarkedAlerter,
                isEmptyValidator
            )
        );

        DefaultObjectToStringMapper turnMapper = new DefaultObjectToStringMapper(OnePlayerModeMessages.defaultTurnMessage);
        turnMapper.register(john, OnePlayerModeMessages.humanTurnMessage);
        turnMapper.register(haley, OnePlayerModeMessages.computerTurnMessage);
        MultiTurnMessenger turnMessenger = Messaging.Factory.makeMappingMultiTurnMessenger(turnMapper, fxMessenger);

        MultiTurn turn = Factory.makeMessagingMultiTurn(john, turnMessenger);
        turn.add(haley);

        GameOverRule rule = Domain.Factory.makeGameOverRule(board);
        WinningLineProvider provider = Domain.Factory.makeWinningLineProvider(board);
        Renderer renderer = new BoardRenderer(fxBoard, provider);
        Game game = Factory.makeGame(rule, turn, renderer);

        GameLoopMessenger loopMessenger = Messaging.Factory.makeTicTacToeGameLoopMessenger(board, fxMessenger);
        GameLoop loop = Factory.makeMessagingGameLoop(game, loopMessenger);

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
