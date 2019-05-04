package App;


import Board.HashingBoard.HashingBoard;
import Mappers.MarkToStringMappers.MarkToXOMapper;
import View.FXBoardView;
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
        HashingBoard board = new HashingBoard();
        MarkToXOMapper mapper = new MarkToXOMapper();

        FXBoardView boardView = new FXBoardView(250, board, mapper);
        FXMessenger messenger = new FXMessenger(250);
        FXShell shell = new FXShell(boardView, messenger);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(shell));
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
