package App;


import Domain.Board.Board;
import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.Data.Mark;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Domain.GameOverInputProcessor.GameOverInputProcessor;
import Domain.IODeviceFactory;
import Domain.InputGeneration.InputValidators.FieldIsEmptyValidator.FieldIsEmptyValidator;
import GuiGaming.GuiTicTacToePlayer.GuiTicTacToePlayer;
import GuiGaming.MultiGuiPlayer.GuiPlayer;
import GuiGaming.Presentation.BoardViewPresenter.BoardViewPresenter;
import GuiGaming.Presentation.WinningLinePresenter.WinningLinePresenter;
import InputGeneration.InputProcessor;
import InputGeneration.ValidInputGenerator.InputAlerter;
import InputGeneration.ValidInputGenerator.InputValidator;
import Mapping.MarkToStringMappers.MarkToXOMapper;
import Messages.AlertingMessages;
import SequentialGaming.GameFacade.GameOverRule;
import SequentialGaming.GameFacade.Player;
import View.FXBoardView;
import View.FXInputAlerter;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static GuiPlayer johnHuman;
    private static GuiPlayer haleyHuman;
    private static Player johnCPU;
    private static Player haleyCPU;

    private static void initPlayers(Board board) {
        johnHuman = new GuiTicTacToePlayer(Mark.John, board);
        haleyHuman = new GuiTicTacToePlayer(Mark.Haley, board);

        IODeviceFactory factory = new FXIODeviceFactory();
        johnCPU = Domain.Factory.makeHumbleComputerPlayer(Mark.John, board, factory);
        haleyCPU = Domain.Factory.makeInvincibleComputerPlayer(Mark.Haley, board, factory);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        ListenableBoard board = new ListenableBoard(new HashingBoard());

        MarkToXOMapper mapper = new MarkToXOMapper();
        FXBoardView view = new FXBoardView(mapper);

        initPlayers(board);
        HybridPlayer player = new HybridPlayer(johnCPU);
        player.add(haleyCPU);

        GameOverRule rule = Domain.Factory.makeGameOverRule(board);
        GuiGame game = new GuiGame(rule, player);
        GuiGameLoop loop = new GuiGameLoop(game);
        TicTacToe tictactoe = new TicTacToe(loop);

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
