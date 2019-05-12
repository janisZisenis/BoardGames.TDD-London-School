package App;


import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Domain.GameOverInputProcessor.GameOverInputProcessor;
import GuiGaming.Presentation.BoardPresenter.BoardViewPresenter;
import GuiGaming.Presentation.WinningLinePresenter.WinningLinePresenter;
import InputGeneration.InputProcessor;
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

        TicTacToeInputProcessor processor = new TicTacToeInputProcessor(board);
        InputProcessor gameOver = new GameOverInputProcessor(processor, Domain.Factory.makeGameOverRule(board));

        WinningLineProvider provider = Domain.Factory.makeWinningLineProvider(board);
        WinningLinePresenter winningLinePresenter = new WinningLinePresenter(view, provider);
        BoardViewPresenter boardViewPresenter = new BoardViewPresenter(board, view, gameOver);

        board.addListener(boardViewPresenter);
        board.addListener(winningLinePresenter);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(view));
        primaryStage.setResizable(false);
        primaryStage.show();

        processor.onStarted();
    }
}
