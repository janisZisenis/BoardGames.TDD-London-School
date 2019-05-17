package FXBoardGames;

import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.Data.BoardBoundaries;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import FXBoardGames.App.PlayerTypeProvider;
import FXBoardGames.App.PlayersChosenStartableProvider;
import FXBoardGames.App.TicTacToeAction;
import FXBoardGames.View.FXTicTacToeView;
import FXView.FXBoardView;
import FXView.FXShell;
import FXView.FXTicTacToeChoosePlayerView;
import FXView.FXTicTacToeConfigureView;
import Presentation.ChoosePlayerViewPresenter.ChoosePlayerViewPresenter;
import Presentation.ConfigureViewPresenter.ConfigureViewPresenter;
import Presentation.MainMenuTransaction.MainMenuTransaction;
import Presentation.ShellPresenter.ShellPresenter;
import Presentation.WinningLinePresenter.WinningLinePresenter;
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

        MainMenuTransaction menuAction = new MainMenuTransaction(shellPresenter);
        PlayersChosenStartableProvider startableProvider = new PlayersChosenStartableProvider(firstPresenter, secondPresenter);
        ConfigureViewPresenter configPresenter = new ConfigureViewPresenter(config, startableProvider, menuAction, tictactoeAction);
        config.setDelegate(configPresenter);
        firstPresenter.attach(configPresenter);

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
