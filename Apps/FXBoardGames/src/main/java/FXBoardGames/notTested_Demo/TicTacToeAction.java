package FXBoardGames.notTested_Demo;

import Domain.Board.Board;
import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.Data.BoardBoundaries;
import Domain.Data.Mark;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
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
import InteractiveGaming.HybridGameRunner.HybridGame;
import InteractiveGaming.HybridGameRunner.HybridGameRunner;
import InteractiveGaming.HybridInputPlayerAdapter.HybridInputPlayerAdapter;
import InteractiveGaming.HybridPlayerAdapter.HybridPlayerAdapter;
import InteractiveGaming.MultiHybridPlayer.MultiHybridPlayer;
import Messages.AlertingMessages;
import Presentation.BoardViewPresenter.BoardViewPresenter;
import Presentation.ChoosePlayerViewPresenter.PlayerType;
import Presentation.Transactions.LoadGameViewTransaction.GameViewLoader;
import Presentation.WinningLinePresenter.WinningLinePresenter;
import Utilities.Transaction.Transaction;

public class TicTacToeAction implements Transaction {

    private final GameViewLoader loader;

    public TicTacToeAction(GameViewLoader loader) {
        this.loader = loader;
    }

    public void execute() {
        FXBoardView boardView = new FXBoardView(BoardBoundaries.rowColumnCount);
        loader.load(boardView);

        ListenableBoard board = new ListenableBoard(new HashingBoard());

        HybridPlayer john = makePlayer(PlayerType.Human, Mark.John, board);
        HybridPlayer haley = makePlayer(PlayerType.Humble, Mark.Haley, board);
        MultiHybridPlayer multiPlayer = new MultiHybridPlayer(john);
        multiPlayer.add(haley);

        GameOverRule rule = Domain.Factory.makeGameOverRule(board);
        HybridGame game = new HybridGameImp(rule, multiPlayer);
        HybridGameRunner runner = new HybridGameRunner(game);

        WinningLineProvider lineProvider = Domain.Factory.makeWinningLineProvider(board);
        WinningLinePresenter winningLinePresenter = new WinningLinePresenter(boardView, lineProvider);
        board.addListener(winningLinePresenter);

        InputValidator validator = new FieldIsEmptyValidator(board);
        InputAlerter alerter = new FXInputAlerter(AlertingMessages.inputAlreadyMarked);
        InputProcessor processor = InputGeneration.Factory.makeAlertingInputProcessor(runner, validator, alerter);
        processor = new GameOverInputProcessor(processor, rule);
        BoardViewPresenter boardPresenter = new BoardViewPresenter(board, boardView, processor);
        board.addListener(boardPresenter);
        boardView.setDelegate(boardPresenter);

//        FXTicTacToeGameOverView gameOverView = new FXTicTacToeGameOverView();
//        GameOverInteractorFacade gameOverViewPresenter = new GameOverInteractorFacade();
//        gameOverView.setDelegate(gameOverViewPresenter);

        runner.run();
    }

    private HybridPlayer makePlayer(PlayerType type, Mark m, Board board) {
        if(type == PlayerType.Invincible)
            return new HybridPlayerAdapter(Domain.Factory.makeInvincibleComputerPlayer(m, board, new FXIODeviceFactory()));
        if(type == PlayerType.Humble)
            return new HybridPlayerAdapter(Domain.Factory.makeHumbleComputerPlayer(m, board, new FXIODeviceFactory()));

        return new HybridInputPlayerAdapter(new TicTacToeInputPlayer(m, board));
    };

}
