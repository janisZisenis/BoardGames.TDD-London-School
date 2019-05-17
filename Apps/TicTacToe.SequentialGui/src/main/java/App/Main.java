package App;

import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Data.BoardBoundaries;
import Domain.Data.Mark;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import FXView.*;
import Gaming.Factory;
import Gaming.GameFacade.GameOverRule;
import Gaming.GameFacade.NullRenderer;
import Gaming.GameFacade.Player;
import Gaming.GameLoopImp.Game;
import Gaming.MessagingGameLoop.GameLoop;
import Gaming.MessagingGameLoop.GameLoopMessenger;
import Gaming.MultiPlayer.MultiPlayer;
import Gaming.MultiPlayer.MultiPlayerMessenger;
import InputGeneration.NullInputProcessor;
import Mapping.ObjectToStringMappers.DefaultObjectToStringMapper;
import Messages.OnePlayerModeMessages;
import Messaging.MessagingBoardListener.HumbleMarkedFieldMessageProviderImp;
import Messaging.MessagingBoardListener.MarkedFieldMessageProvider;
import Messaging.MessagingBoardListener.MessagingBoardListener;
import Presentation.BoardViewPresenter.BoardViewPresenter;
import Presentation.WinningLinePresenter.WinningLinePresenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        ListenableBoard board = Domain.Factory.makeListenableBoard();

        FXInputView fxGenerator = new FXInputView(200);
        FXSynchronizingBoardView fxBoard = new FXSynchronizingBoardView(BoardBoundaries.rowColumnCount, 200);
        FXSynchronizingMessengerView fxMessenger = new FXSynchronizingMessengerView(445);
        FXSequentialShell fxShell = new FXSequentialShell(fxBoard, fxGenerator, fxMessenger);

        MarkedFieldMessageProvider markedFieldMessageProvider = new HumbleMarkedFieldMessageProviderImp();
        MessagingBoardListener listener = new MessagingBoardListener(fxMessenger, markedFieldMessageProvider);
        board.addListener(listener);

        FXIODeviceFactory factory = new FXIODeviceFactory();
        FXIODeviceFactory.setHumanInputGenerator(fxGenerator);
        Player john = Domain.Factory.makeHumanPlayer(Mark.John, board, factory);
        Player haley = Domain.Factory.makeInvincibleComputerPlayer(Mark.Haley, board, factory);

        DefaultObjectToStringMapper playerMapper = new DefaultObjectToStringMapper(OnePlayerModeMessages.defaultPlayerMessage);
        playerMapper.register(john, OnePlayerModeMessages.humanPlayerMessage);
        playerMapper.register(haley, OnePlayerModeMessages.computerPlayerMessage);
        MultiPlayerMessenger multiPlayerMessenger = Messaging.Factory.makeMappingMultiPlayerMessenger(playerMapper, fxMessenger);

        MultiPlayer player = Factory.makeMessagingMultiPlayer(john, multiPlayerMessenger);
        player.add(haley);

        GameOverRule rule = Domain.Factory.makeGameOverRule(board);
        WinningLineProvider provider = Domain.Factory.makeWinningLineProvider(board);
        Game game = Factory.makeGame(rule, player, new NullRenderer());

        WinningLinePresenter winningLinePresenter = new WinningLinePresenter(fxBoard, provider);
        board.addListener(winningLinePresenter);

        BoardViewPresenter boardPresenter = new BoardViewPresenter(board, fxBoard, new NullInputProcessor());
        board.addListener(boardPresenter);

        GameLoopMessenger loopMessenger = Messaging.Factory.makeTicTacToeGameLoopMessenger(board, fxMessenger);
        GameLoop loop = Factory.makeMessagingGameLoop(game, loopMessenger);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(fxShell));
        primaryStage.setResizable(false);
        primaryStage.show();

        Thread t = new Thread() {
            public void run(){
                loop.run();
            }
        };

        t.start();

    }

}
