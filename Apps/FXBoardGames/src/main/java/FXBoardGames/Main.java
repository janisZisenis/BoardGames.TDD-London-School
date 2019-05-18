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
import Presentation.ChoosePlayerViewPresenter.ChoosePlayerViewPresenter;
import Presentation.ConfigureViewPresenter.ConfigureViewPresenter;
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
        FXShell shell = new FXShell();

        ListenableBoard board = new ListenableBoard(new HashingBoard());
        FXBoardView boardView = new FXBoardView(BoardBoundaries.rowColumnCount);
        WinningLineProvider lineProvider = Domain.Factory.makeWinningLineProvider(board);
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
        view.addGame("TicTacToe");
        view.addComingSoon("Monster TicTacToe [N x N]");
        view.addComingSoon("Conway's Game of Life");
        view.addComingSoon("Four in a Row");
        view.addComingSoon("Draughts");
        view.addComingSoon("Chess");

        shell.loadGameView(view);

        primaryStage.setTitle("Board Games");
        Scene scene = new Scene(shell);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

}
