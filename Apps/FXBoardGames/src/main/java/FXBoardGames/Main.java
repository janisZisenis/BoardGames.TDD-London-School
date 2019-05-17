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
import FXView.FXTicTacToeChoosePlayerView;
import FXView.FXTicTacToeConfigureView;
import Presentation.ChoosePlayerViewPresenter.ChoosePlayerViewPresenter;
import Presentation.ConfigureViewPresenter.ConfigureViewPresenter;
import Presentation.WinningLinePresenter.WinningLinePresenter;
import Utilities.Transaction.NullTransaction;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
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

        PlayersChosenStartableProvider startableProvider = new PlayersChosenStartableProvider(firstPresenter, secondPresenter);
        ConfigureViewPresenter configPresenter = new ConfigureViewPresenter(config, startableProvider, new NullTransaction(), tictactoeAction);
        config.setDelegate(configPresenter);
        firstPresenter.attach(configPresenter);



        primaryStage.setTitle("Board Games");
        Scene scene = new Scene(tictactoe);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.show();
    }

}
