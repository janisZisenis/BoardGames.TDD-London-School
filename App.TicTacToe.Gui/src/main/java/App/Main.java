package App;


import Domain.Board.HashingBoard.HashingBoard;
import Domain.Board.ListenableBoard.ListenableBoard;
import Mapping.MarkToStringMappers.MarkToXOMapper;
import View.FXBoardView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        ListenableBoard board = new ListenableBoard(new HashingBoard());
        MarkToXOMapper mapper = new MarkToXOMapper();
        FXBoardView view = new FXBoardView(mapper);
        TicTacToePresenter presenter = new TicTacToePresenter(view, board);
        view.setDelegate(presenter);

        board.setListener(presenter);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(view));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
