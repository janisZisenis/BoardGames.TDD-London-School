package App;

import Domain.Board.Board;
import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.Data.BoardBoundaries;
import Domain.Data.Mark;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Domain.IODeviceFactory;
import Domain.InputGeneration.GameOverInputProcessor.GameOverInputProcessor;
import Domain.InputGeneration.InputValidators.FieldIsEmptyValidator.FieldIsEmptyValidator;
import Domain.InteractiveGaming.TicTacToeInputPlayer.TicTacToeInputPlayer;
import FXView.FXBoardView;
import FXView.FXIODeviceFactory;
import FXView.FXInputAlerter;
import Gaming.GameFacade.GameOverRule;
import InputGeneration.InputProcessor;
import InputGeneration.ValidInputGenerator.InputAlerter;
import InputGeneration.ValidInputGenerator.InputValidator;
import InteractiveGaming.HybridGameImp.HybridGameImp;
import InteractiveGaming.HybridGameImp.HybridPlayer;
import InteractiveGaming.HybridGameRunner.HybridGameRunner;
import InteractiveGaming.HybridInputPlayerAdapter.HybridInputPlayerAdapter;
import InteractiveGaming.HybridPlayerAdapter.HybridPlayerAdapter;
import InteractiveGaming.MultiHybridPlayer.MultiHybridPlayer;
import Messages.AlertingMessages;
import Presentation.BoardViewPresenter.BoardViewPresenter;
import Presentation.WinningLinePresenter.WinningLinePresenter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static HybridPlayer johnHuman;
    private static HybridPlayer haleyHuman;
    private static HybridPlayer johnCPU;
    private static HybridPlayer haleyCPU;

    private static void initPlayers(Board board) {
        johnHuman = new HybridInputPlayerAdapter(new TicTacToeInputPlayer(Mark.John, board));
        haleyHuman = new HybridInputPlayerAdapter(new TicTacToeInputPlayer(Mark.Haley, board));

        IODeviceFactory factory = new FXIODeviceFactory();
        johnCPU = new HybridPlayerAdapter(Domain.Factory.makeInvincibleComputerPlayer(Mark.John, board, factory));
        haleyCPU = new HybridPlayerAdapter(Domain.Factory.makeInvincibleComputerPlayer(Mark.Haley, board, factory));
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        ListenableBoard board = new ListenableBoard(new HashingBoard());
        initPlayers(board);

        FXBoardView view = new FXBoardView(BoardBoundaries.rowColumnCount);
        view.setSideLength(300);

        GameOverRule rule = Domain.Factory.makeGameOverRule(board);

        MultiHybridPlayer player = new MultiHybridPlayer(johnCPU);
        player.add(haleyHuman);
        HybridGameImp game = new HybridGameImp(rule, player);
        HybridGameRunner runner = new HybridGameRunner(game);

        InputValidator validator = new FieldIsEmptyValidator(board);
        InputAlerter alerter = new FXInputAlerter(AlertingMessages.inputAlreadyMarked);
        InputProcessor processor = InputGeneration.Factory.makeAlertingInputProcessor(runner, validator, alerter);
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

        runner.run();
    }
}
