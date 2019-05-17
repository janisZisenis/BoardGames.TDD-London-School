package FXBoardGames;

import FXBoardGames.App.PlayersChosenStartableProvider;
import FXBoardGames.View.FXBoardView;
import FXBoardGames.View.FXTicTacToeView;
import FXView.FXShell;
import FXView.FXTicTacToeChoosePlayerView;
import FXView.FXTicTacToeConfigureView;
import Presentation.ChoosePlayerViewPresenter.ChoosePlayerViewPresenter;
import Presentation.ConfigureViewPresenter.ConfigureViewPresenter;
import Presentation.ConfigureViewPresenter.IsNotStartableProvider;
import Presentation.MainMenuTransaction.MainMenuTransaction;
import Presentation.ShellPresenter.ShellPresenter;
import Utilities.Transaction.NullTransaction;
import Utilities.Transaction.Transaction;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXShell shell = new FXShell();
        ShellPresenter shellPresenter = new ShellPresenter(shell);
        shell.setDelegate(shellPresenter);

        FXBoardView boardView = new FXBoardView(3);

        FXTicTacToeChoosePlayerView first = new FXTicTacToeChoosePlayerView();
        ChoosePlayerViewPresenter firstPresenter = new ChoosePlayerViewPresenter(first);
        first.setDelegate(firstPresenter);

        FXTicTacToeChoosePlayerView second = new FXTicTacToeChoosePlayerView();
        ChoosePlayerViewPresenter secondPresenter = new ChoosePlayerViewPresenter(second);
        second.setDelegate(secondPresenter);

        FXTicTacToeConfigureView config = new FXTicTacToeConfigureView(first, second);
        Transaction mainMenuAction = new MainMenuTransaction(shellPresenter);
        PlayersChosenStartableProvider startableProvider = new PlayersChosenStartableProvider(firstPresenter, secondPresenter);
        ConfigureViewPresenter configPresenter = new ConfigureViewPresenter(config, new IsNotStartableProvider(), mainMenuAction, new NullTransaction());
        config.setDelegate(configPresenter);
        firstPresenter.attach(configPresenter);

        FXTicTacToeView tictactoe = new FXTicTacToeView(config, boardView);

        shellPresenter.addGame(tictactoe, "TicTacToe");
        shellPresenter.addComingSoon("Conway's Game of Life");
        shellPresenter.addComingSoon("Four in a Row");
        shellPresenter.addComingSoon("Draughts");
        shellPresenter.addComingSoon("Chess");

        primaryStage.setTitle("Board Games");
        Scene scene = new Scene(shell);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

}
