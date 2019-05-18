package FXBoardGames;

import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.Data.BoardBoundaries;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import FXBoardGames.App.PlayerTypeProvider;
import FXBoardGames.App.PlayersChosenStartableProvider;
import FXBoardGames.App.TicTacToeAction;
import FXBoardGames.View.FXTicTacToeView;
import FXView.*;
import FXView.FXQuitTransaction.FXQuitTransaction;
import Presentation.ChoosePlayerViewPresenter.ChoosePlayerViewPresenter;
import Presentation.ConfigureViewPresenter.ConfigureViewPresenter;
import Presentation.Transactions.LoadGameViewTransaction.LoadGameViewTransaction;
import Presentation.WelcomeViewPresenter.WelcomeViewPresenter;
import Presentation.WinningLinePresenter.WinningLinePresenter;
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
        ListenableBoard board = new ListenableBoard(new HashingBoard());
        WinningLineProvider lineProvider = Domain.Factory.makeWinningLineProvider(board);

        FXBoardView boardView = new FXBoardView(BoardBoundaries.rowColumnCount);
        WinningLinePresenter winningLinePresenter = new WinningLinePresenter(boardView, lineProvider);
        board.addListener(winningLinePresenter);

        FXTicTacToeChoosePlayerView first = new FXTicTacToeChoosePlayerView();
        ChoosePlayerViewPresenter firstPresenter = new ChoosePlayerViewPresenter(first);
        first.setDelegate(firstPresenter);

        FXTicTacToeChoosePlayerView second = new FXTicTacToeChoosePlayerView();
        ChoosePlayerViewPresenter secondPresenter = new ChoosePlayerViewPresenter(second);
        second.setDelegate(secondPresenter);

        FXTicTacToeConfigureView config = new FXTicTacToeConfigureView(first, second);
        FXTicTacToeView tictactoe = new FXTicTacToeView(config, boardView);
        tictactoe.setSideLength(400);

        PlayerTypeProvider playerTypeProvider = new PlayerTypeProvider(firstPresenter, secondPresenter);
        TicTacToeAction tictactoeAction = new TicTacToeAction(tictactoe, board, boardView, playerTypeProvider);

        Transaction menuAction = new NullTransaction();
        PlayersChosenStartableProvider startableProvider = new PlayersChosenStartableProvider(firstPresenter, secondPresenter);
        ConfigureViewPresenter configPresenter = new ConfigureViewPresenter(config, startableProvider, menuAction, tictactoeAction);
        config.setDelegate(configPresenter);
        firstPresenter.attach(configPresenter);

        FXWelcomeView view = new FXWelcomeView();
        WelcomeViewPresenter presenter = new WelcomeViewPresenter(view);
        view.setDelegate(presenter);

        FXShell shell = new FXShell();
        shell.load(view);

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

        loadAction.execute();
    }

}
