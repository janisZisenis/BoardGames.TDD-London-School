package FXBoardGames;

import FXBoardGames.App.PlayersChosenStartableProvider;
import FXBoardGames.App.TicTacToeAction;
import FXView.FXQuitTransaction.FXQuitTransaction;
import FXView.FXShell;
import FXView.FXTicTacToeChoosePlayerView;
import FXView.FXTicTacToeConfigureView;
import FXView.FXWelcomeView;
import Presentation.ChoosePlayerViewPresenter.ChoosePlayerViewPresenter;
import Presentation.ConfigureViewPresenter.ConfigureViewPresenter;
import Presentation.Transactions.LoadGameViewTransaction.LoadGameViewTransaction;
import Presentation.WelcomeViewPresenter.WelcomeViewPresenter;
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
        FXWelcomeView welcomeView = new FXWelcomeView();
        WelcomeViewPresenter presenter = new WelcomeViewPresenter(welcomeView);
        welcomeView.setDelegate(presenter);
        shell.load(welcomeView);

        FXTicTacToeChoosePlayerView first = new FXTicTacToeChoosePlayerView();
        ChoosePlayerViewPresenter firstPresenter = new ChoosePlayerViewPresenter(first);
        first.setDelegate(firstPresenter);

        FXTicTacToeChoosePlayerView second = new FXTicTacToeChoosePlayerView();
        ChoosePlayerViewPresenter secondPresenter = new ChoosePlayerViewPresenter(second);
        second.setDelegate(secondPresenter);

        Transaction menuAction = new LoadGameViewTransaction(welcomeView ,shell);
        Transaction runAction = new TicTacToeAction(null, shell);
        FXTicTacToeConfigureView config = new FXTicTacToeConfigureView(first, second);
        PlayersChosenStartableProvider startableProvider = new PlayersChosenStartableProvider(firstPresenter, secondPresenter);
        ConfigureViewPresenter configPresenter = new ConfigureViewPresenter(config, startableProvider, menuAction, runAction);
        config.setDelegate(configPresenter);
        firstPresenter.attach(configPresenter);

        Transaction loadAction = new LoadGameViewTransaction(config, shell);
        presenter.addAction(loadAction, "TicTacToe");
        presenter.addComingSoonAction("Conway's Game of Life");
        presenter.addComingSoonAction("Four in a Row");
        presenter.addComingSoonAction("Draughts");
        presenter.addComingSoonAction("Chess");
        presenter.addAction(new FXQuitTransaction(), "Quit Board Games!");

        primaryStage.setTitle("Board Games");
        Scene scene = new Scene(shell);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

}
