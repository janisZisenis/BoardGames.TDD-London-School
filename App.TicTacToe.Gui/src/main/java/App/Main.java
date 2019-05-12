package App;


import Domain.Board.Board;
import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Domain.GameEvaluation.GameEvaluator.GameEvaluator;
import Domain.GameEvaluation.GameEvaluator.LineEvaluator;
import Domain.GameEvaluation.GameEvaluator.LineProvider;
import Domain.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Mapping.MarkToStringMappers.MarkToXOMapper;
import View.FXBoardView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static WinningLineProvider makeWinningLineProvider(Board board) {
        LineEvaluator lineEvaluator = new EquallyMarkedLineEvaluator(board);
        LineProvider lineProvider = new HumbleLineProvider();
        return new GameEvaluator(lineProvider, lineEvaluator);
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        ListenableBoard board = new ListenableBoard(new HashingBoard());

        MarkToXOMapper mapper = new MarkToXOMapper();
        FXBoardView view = new FXBoardView(mapper);
        TicTacToePresenter presenter = new TicTacToePresenter(board, view);
        view.setDelegate(presenter);
        board.addListener(presenter);

        presenter.onStarted();

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(view));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
