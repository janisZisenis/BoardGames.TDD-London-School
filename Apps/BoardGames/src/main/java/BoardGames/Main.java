package BoardGames;

import BoardGames.View.FXShell;
import BoardGames.View.FXTicTacToeView;
import Presentation.ShellPresenter.ShellPresenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXShell shell = new FXShell();
        FXTicTacToeView tictactoe = new FXTicTacToeView();

        ShellPresenter presenter = new ShellPresenter(shell);
        shell.setDelegate(presenter);

        presenter.addGame(tictactoe, "TicTacToe");
        presenter.addComingSoon("Conway's Game of Life");
        presenter.addComingSoon("Four in a Row");
        presenter.addComingSoon("Draughts");
        presenter.addComingSoon("Chess");

        primaryStage.setTitle("Board Games");
        Scene scene = new Scene(shell);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }
}
