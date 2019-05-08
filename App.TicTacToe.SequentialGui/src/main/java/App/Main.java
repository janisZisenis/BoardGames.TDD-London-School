package App;

import Domain.Board.ListenableBoard.ListenableBoard;
import Domain.Data.Mark;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Mapping.MarkToStringMappers.MarkToXOMapper;
import Mapping.ObjectToStringMappers.DefaultObjectToStringMapper;
import Messages.OnePlayerModeMessages;
import Messaging.MessagingBoardListener.HumbleMarkedFieldMessageProviderImp;
import Messaging.MessagingBoardListener.MarkedFieldMessageProvider;
import Messaging.MessagingBoardListener.MessagingBoardListener;
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
import View.FXBoardView;
import View.FXInputView;
import View.FXMessenger;
import View.FXShell;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        ListenableBoard board = Domain.Factory.makeListenableBoard();

        FXIODeviceFactory factory = new FXIODeviceFactory();
        FXInputView fxGenerator = (FXInputView) factory.makeHumanInputGenerator();
        FXBoardView fxBoard = new FXBoardView(200, board, new MarkToXOMapper());
        FXMessenger fxMessenger = new FXMessenger(445);
        FXShell fxShell = new FXShell(fxBoard, fxGenerator, fxMessenger);

        MarkedFieldMessageProvider markedFieldMessageProvider = new HumbleMarkedFieldMessageProviderImp();
        MessagingBoardListener listener = new MessagingBoardListener(fxMessenger, markedFieldMessageProvider);
        board.setListener(listener);

        Turn john = Domain.Factory.makeHumanTurn(Mark.John, board, factory);
        Turn haley = Domain.Factory.makeInvincableComputerTurn(Mark.Haley, board, factory);

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
