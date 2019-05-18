package FXBoardGames.notTested_Demo;

import Domain.Board.Board;
import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Board.BoardDecorators.ObservableBoard.ObservableBoard;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.Data.BoardBoundaries;
import Domain.Data.Mark;
import Domain.GameEvaluation.GameEvaluator.Api.WinnerProvider;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Domain.InputGeneration.GameOverInputProcessor.GameOverInputProcessor;
import Domain.InputGeneration.InputValidators.FieldIsEmptyValidator.FieldIsEmptyValidator;
import Domain.InteractiveGaming.TicTacToeInputPlayer.TicTacToeInputPlayer;
import FXView.*;
import FXView.Gaming.FXBoardView;
import FXView.Gaming.FXGameOverView;
import FXView.Gaming.FXInputAlerter;
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
import Mapping.MarkToStringMappers.DefaultMarkToStringMapper;
import Messages.AlertingMessages;
import Messages.TicTacToeMessages;
import Messaging.MessageProviders.FixedMessageProvider.FixedMessageProvider;
import Messaging.MessageProviders.GameOverMessageProvider.GameOverMessageProvider;
import Messaging.MessageProviders.GameOverMessageProvider.WinnerMessageProvider;
import Messaging.WinnerMessageProviderImp.WinnerMessageProviderImp;
import Presentation.BoardViewPresenter.BoardViewPresenter;
import Presentation.ChoosePlayerViewPresenter.PlayerType;
import Presentation.GameOverView.GameOverViewInteractorFacade.GameOverInteractorFacade;
import Presentation.GameOverView.GameOverViewPresenter.GameOverViewPresenter;
import Presentation.Transactions.LoadGameViewTransaction.GameViewLoader;
import Presentation.WinningLinePresenter.WinningLinePresenter;
import Utilities.Transaction.Transaction;

public class TicTacToeAction implements Transaction {

    private final GameViewLoader loader;
    private final Transaction menuAction;
    private final Transaction configureAction;

    public TicTacToeAction(GameViewLoader loader, Transaction menuAction, Transaction configureAction) {
        this.loader = loader;
        this.menuAction = menuAction;
        this.configureAction = configureAction;
    }

    public void execute() {
        FXBoardView boardView = new FXBoardView(BoardBoundaries.rowColumnCount);

        Board hashing = new HashingBoard();
        ObservableBoard observableBoard = new ObservableBoard(hashing);
        ListenableBoard board = new ListenableBoard(observableBoard);

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

        Transaction cancelAction = menuAction;
        Transaction reconfigureAction = configureAction;
        Transaction restartAction = this;

        WinnerProvider winnerProvider = Domain.Factory.makeWinnerProvider(board);
        DefaultMarkToStringMapper mapper = new DefaultMarkToStringMapper(TicTacToeMessages.xWinsMessage, TicTacToeMessages.oWinsMessage);
        WinnerMessageProvider winnerMessageProvider = new WinnerMessageProviderImp(winnerProvider, mapper);
        FixedMessageProvider drawMessageProvider = new FixedMessageProvider(TicTacToeMessages.drawMessage);
        GameOverMessageProvider provider = new GameOverMessageProvider(winnerMessageProvider, drawMessageProvider);
        GameOverInteractorFacade gameOverViewInteractor = new GameOverInteractorFacade(rule, provider, cancelAction, reconfigureAction, restartAction);

        FXGameOverView gameOverView = new FXGameOverView();
        GameOverViewPresenter gameOverViewPresenter = new GameOverViewPresenter(gameOverView, gameOverViewInteractor);
        gameOverView.setDelegate(gameOverViewPresenter);
        observableBoard.attach(gameOverViewPresenter);

        FXTicTacToeView view = new FXTicTacToeView(boardView, gameOverView);
        loader.load(view);

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
