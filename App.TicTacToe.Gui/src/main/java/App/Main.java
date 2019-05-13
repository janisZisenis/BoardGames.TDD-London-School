package App;


import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Domain.GameOverInputProcessor.GameOverInputProcessor;
import Domain.InputGeneration.InputValidators.FieldIsEmptyValidator.FieldIsEmptyValidator;
import GuiGaming.Presentation.BoardViewPresenter.BoardViewPresenter;
import GuiGaming.Presentation.WinningLinePresenter.WinningLinePresenter;
import InputGeneration.InputProcessor;
import InputGeneration.ValidInputGenerator.InputAlerter;
import InputGeneration.ValidInputGenerator.InputValidator;
import Mapping.MarkToStringMappers.MarkToXOMapper;
import Messages.AlertingMessages;
import SequentialGaming.GameFacade.GameOverRule;
import View.FXBoardView;
import View.FXInputAlerter;
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

        TicTacToe tictactoe = new TicTacToe(board);

        InputValidator validator = new FieldIsEmptyValidator(board);
        InputAlerter alerter = new FXInputAlerter(AlertingMessages.inputAlreadyMarked);
        InputProcessor processor = InputGeneration.Factory.makeAlertingInputProcessor(tictactoe, validator, alerter);
        GameOverRule rule = Domain.Factory.makeGameOverRule(board);
        processor = new GameOverInputProcessor(processor, rule);

        BoardViewPresenter boardPresenter = new BoardViewPresenter(board, view, processor);
        view.setDelegate(boardPresenter);

        WinningLineProvider provider = Domain.Factory.makeWinningLineProvider(board);
        WinningLinePresenter winningLinePresenter = new WinningLinePresenter(view, provider);
        board.addListener(boardPresenter);
        board.addListener(winningLinePresenter);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(view));
        primaryStage.setResizable(false);
        primaryStage.show();

        tictactoe.start();
    }
}
