package App;


import Domain.Board.Board;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.Board.ListenableBoard.ListenableBoard;
import Domain.Data.Mark;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Domain.GameEvaluation.GameEvaluator.GameEvaluator;
import Domain.GameEvaluation.GameEvaluator.LineEvaluator;
import Domain.GameEvaluation.GameEvaluator.LineProvider;
import Domain.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Domain.InputGeneration.InputValidators.FieldIsEmptyValidator.FieldIsEmptyValidator;
import Domain.InputGeneration.InputValidators.GameOverValidator.GameOverValidator;
import GuiGaming.GuiPlayer;
import GuiGaming.GuiTicTacToePlayer.GuiTicTacToePlayer;
import GuiGaming.MultiGuiPlayer.MultiGuiPlayer;
import GuiGaming.PlayingInputProcessor.PlayingInputProcessor;
import GuiGaming.TicTacToePresenter.TicTacToe;
import GuiGaming.TicTacToeFacade.TicTacToeFacade;
import InputGeneration.InputProcessor;
import InputGeneration.ValidInputGenerator.InputAlerter;
import InputGeneration.ValidInputGenerator.InputValidator;
import Mapping.MarkToStringMappers.MarkToXOMapper;
import Messages.AlertingMessages;
import SequentialGaming.DelegatingGame.GameOverRule;
import View.FXBoardView;
import View.FXInputAlerter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static InputProcessor makeProcessor(Board board) {
        GuiPlayer first = new GuiTicTacToePlayer(Mark.John, board);
        GuiPlayer  second = new GuiTicTacToePlayer(Mark.Haley, board);

        MultiGuiPlayer player = new MultiGuiPlayer(first);
        player.add(second);

        GameOverRule rule = Domain.Factory.makeGameOverRule(board);
        InputValidator emptyValidator = new FieldIsEmptyValidator(board);
        InputAlerter alerter = new FXInputAlerter(AlertingMessages.inputAlreadyMarked);
        InputValidator gameOverValidator = new GameOverValidator(rule);

        InputProcessor processor = new PlayingInputProcessor(player);
        processor = InputGeneration.Factory.makeAlertingInputProcessor(processor, emptyValidator, alerter);
        processor = InputGeneration.Factory.makeValidatingInputProcessor(processor, gameOverValidator);

        return processor;
    }

    private static WinningLineProvider makeWinningLineProvider(Board board) {
        LineEvaluator lineEvaluator = new EquallyMarkedLineEvaluator(board);
        LineProvider lineProvider = new HumbleLineProvider();
        return new GameEvaluator(lineProvider, lineEvaluator);
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        ListenableBoard board = new ListenableBoard(new HashingBoard());

        InputProcessor processor = makeProcessor(board);
        WinningLineProvider provider = makeWinningLineProvider(board);
        TicTacToe ticTacToe = new TicTacToeFacade(board, provider, processor);

        MarkToXOMapper mapper = new MarkToXOMapper();
        FXBoardView view = new FXBoardView(mapper);
        TicTacToePresenter presenter = new TicTacToePresenter(view, ticTacToe);
        view.setDelegate(presenter);

        board.setListener(presenter);

        primaryStage.setTitle("TicTacToe");
        primaryStage.setScene(new Scene(view));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
