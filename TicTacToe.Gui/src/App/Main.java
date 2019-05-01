package App;

import Lib.Board.HashingBoard.HashingBoard;
import Lib.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Lib.GameEvaluation.GameEvaluator.GameEvaluator;
import Lib.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Lib.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputAlerter;
import Lib.MarkToStringMapper.MarkToXOMapper;
import Lib.Messages.AlertingMessages;
import View.FXBoardView;
import View.FXInputAlerter;
import View.FXLoggerView;
import View.FXShell;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        primaryStage.setTitle("TicTacToe");
        Scene root = makeContent();
        primaryStage.setScene(root);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private Scene makeContent() {

        HashingBoard board = new HashingBoard();
        MarkToXOMapper mapper = new MarkToXOMapper();
        HumbleLineProvider lineProvider = new HumbleLineProvider();
        EquallyMarkedLineEvaluator lineEvaluator = new EquallyMarkedLineEvaluator(board);
        GameEvaluator gameEvaluator = new GameEvaluator(lineProvider, lineEvaluator);
        InputAlerter alerter = new FXInputAlerter(AlertingMessages.inputAlreadyMarked);

        FXBoardView boardView = new FXBoardView(300, board, mapper);
        FXLoggerView loggerView = new FXLoggerView(300, gameEvaluator, mapper);

//        Renderer renderer = new BoardRenderer(boardView, gameEvaluator);
//        GameLoop loop = new GameLoopImp();
//        Game game = new GameImp(renderer, loop);
//        Game messagingGame = new MessagingGame(game, loggerView);
//        messagingGame.play();


        return new Scene(new FXShell(boardView, loggerView));
    }

}
