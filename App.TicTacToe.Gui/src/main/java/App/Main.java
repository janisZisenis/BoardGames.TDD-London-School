package App;


import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Domain.GameOverInputProcessor.GameOverInputProcessor;
import GuiGaming.Presentation.BoardViewPresenter.BoardViewPresenter;
import GuiGaming.Presentation.WinningLinePresenter.WinningLinePresenter;
import InputGeneration.InputProcessor;
import Mapping.MarkToStringMappers.MarkToXOMapper;
import View.FXBoardView;
import View.FXGameOverView;
import View.FXStartView;
import View.FXTicTacToeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        ListenableBoard board = new ListenableBoard(new HashingBoard());

        MarkToXOMapper mapper = new MarkToXOMapper();
        FXBoardView view = new FXBoardView(mapper);

        StackPane pane = new StackPane();
        pane.setPrefSize(400, 400);

        FXStartView start = new FXStartView();
        FXGameOverView goView = new FXGameOverView();
        FXTicTacToeView ticTacToeView = new FXTicTacToeView(view, start, goView);

        pane.getChildren().addAll(ticTacToeView, start);

        TicTacToeInputProcessor processor = new TicTacToeInputProcessor(board);
        InputProcessor gameOver = new GameOverInputProcessor(processor, Domain.Factory.makeGameOverRule(board));

        WinningLineProvider provider = Domain.Factory.makeWinningLineProvider(board);
        WinningLinePresenter winningLinePresenter = new WinningLinePresenter(view, provider);
        BoardViewPresenter boardViewPresenter = new BoardViewPresenter(board, view, gameOver);


        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(pane));
        primaryStage.setResizable(false);
        primaryStage.show();

        processor.onStarted();
    }
}
