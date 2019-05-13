package App;


import Domain.Board.Board;
import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.Data.Mark;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Domain.GameOverInputProcessor.GameOverInputProcessor;
import Domain.IODeviceFactory;
import Domain.InputGeneration.InputValidators.FieldIsEmptyValidator.FieldIsEmptyValidator;
import GuiGaming.HybridGameFacade.Api.HybridGame;
import GuiGaming.HybridGameFacade.HybridGameFacade;
import GuiGaming.HybridGuiPlayerAdapter.HybridGuiPlayerAdapter;
import GuiGaming.HybridPlayerAdapter.HybridPlayerAdapter;
import GuiGaming.MultiHybridPlayer.HybridPlayer;
import GuiGaming.MultiHybridPlayer.MultiHybridPlayer;
import GuiGaming.Presentation.BoardViewPresenter.BoardViewPresenter;
import GuiGaming.Presentation.WinningLinePresenter.WinningLinePresenter;
import GuiGaming.TicTacToeGuiPlayer.TicTacToeGuiPlayer;
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

    private static HybridPlayer johnHuman;
    private static HybridPlayer haleyHuman;
    private static HybridPlayer johnCPU;
    private static HybridPlayer haleyCPU;

    private static void initPlayers(Board board) {
        johnHuman = new HybridGuiPlayerAdapter(new TicTacToeGuiPlayer(Mark.John, board));
        haleyHuman = new HybridGuiPlayerAdapter(new TicTacToeGuiPlayer(Mark.Haley, board));

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

        MarkToXOMapper mapper = new MarkToXOMapper();
        FXBoardView view = new FXBoardView(mapper);

        GameOverRule rule = Domain.Factory.makeGameOverRule(board);

        MultiHybridPlayer player = new MultiHybridPlayer(johnHuman);
        player.add(haleyHuman);
        HybridGame game = new HybridGameFacade(rule, player);
        TicTacToe tictactoe = new TicTacToe(game);

        InputValidator validator = new FieldIsEmptyValidator(board);
        InputAlerter alerter = new FXInputAlerter(AlertingMessages.inputAlreadyMarked);
        InputProcessor processor = InputGeneration.Factory.makeAlertingInputProcessor(tictactoe, validator, alerter);
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
