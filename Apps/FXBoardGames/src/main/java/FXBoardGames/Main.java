package FXBoardGames;

import FXBoardGames.View.FXBoardView;
import FXBoardGames.View.FXTicTacToeConfigView;
import FXBoardGames.View.FXTicTacToeView;
import FXView.FXTicTacToeChoosePlayerView;
import Presentation.ChoosePlayerViewPresenter.ChoosePlayerViewPresenter;
import Presentation.ShellPresenter.ShellPresenter;
import View.FXShell;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXShell shell = new FXShell();

        FXBoardView boardView = new FXBoardView(3);

        FXTicTacToeChoosePlayerView first = new FXTicTacToeChoosePlayerView();
        ChoosePlayerViewPresenter firstPresenter = new ChoosePlayerViewPresenter(first);
        first.setDelegate(firstPresenter);

        FXTicTacToeChoosePlayerView second = new FXTicTacToeChoosePlayerView();
        ChoosePlayerViewPresenter secondPresenter = new ChoosePlayerViewPresenter(second);
        second.setDelegate(secondPresenter);

        FXTicTacToeConfigView config = new FXTicTacToeConfigView(first, second);
        FXTicTacToeView tictactoe = new FXTicTacToeView(config, boardView);


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
