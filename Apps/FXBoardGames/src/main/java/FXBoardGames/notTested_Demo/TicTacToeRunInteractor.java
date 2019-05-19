package FXBoardGames.notTested_Demo;

import Domain.Board.Board;
import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Board.BoardDecorators.ObservableBoard.ObservableBoard;
import Domain.Board.HashingBoard.HashingBoard;
import Domain.Data.BoardBoundaries;
import Domain.Data.Mark;
import Domain.GameEvaluation.GameEvaluator.Api.WinnerProvider;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import Domain.Input2D.InputValidators.FieldIsEmptyValidator.FieldIsEmptyValidator;
import Domain.TicTacToeInputPlayer.TicTacToeInputPlayer;
import FXSynchronizingView.FXSynchronizingGameOverView;
import FXView.FXIODeviceFactory;
import FXView.FXTicTacToeView;
import FXView.Gaming.FXBoardView;
import FXView.Gaming.FXInputAlerter;
import Gaming.GameFacade.GameOverRule;
import Input2D.InputProcessor;
import Input2D.ValidInputGenerator.InputAlerter;
import Input2D.ValidInputGenerator.InputValidator;
import InteractiveGaming.AsyncProcessingGameRunner.AsyncProcessingGameRunner;
import InteractiveGaming.GameOverInputProcessor.GameOverInputProcessor;
import InteractiveGaming.HybridGameImp.HybridGameImp;
import InteractiveGaming.HybridGameImp.HybridPlayer;
import InteractiveGaming.HybridGameRunner.HybridGame;
import InteractiveGaming.HybridInputPlayerAdapter.HybridInputPlayerAdapter;
import InteractiveGaming.HybridPlayerAdapter.HybridPlayerAdapter;
import InteractiveGaming.MultiHybridPlayer.MultiHybridPlayer;
import InteractiveGaming.ResetTransaction.ResetTransaction;
import MessageProviders.FixedMessageProvider.FixedMessageProvider;
import MessageProviders.GameOverMessageProvider.GameOverMessageProvider;
import MessageProviders.GameOverMessageProvider.WinnerMessageProvider;
import Messages.AlertingMessages;
import Messages.TicTacToeMessages;
import Messaging.MarkToStringMappers.DefaultMarkToStringMapper;
import Messaging.WinnerMessageProviderImp.WinnerMessageProviderImp;
import Presentation.BoardViewPresenter.BoardViewPresenter;
import Presentation.ConfigureViewPresenter.PlayerType;
import Presentation.ConfigureViewPresenter.RunInteractor;
import Presentation.ConfigureViewPresenter.RunRequest;
import Presentation.GameOverViewPresenter.GameOverInteractorFacade;
import Presentation.GameOverViewPresenter.GameOverViewPresenter;
import Presentation.LoadGameViewTransaction.GameView;
import Presentation.LoadGameViewTransaction.GameViewLoader;
import Presentation.WinningLinePresenter.WinningLinePresenter;
import Utilities.Transaction.Transaction;

public class TicTacToeRunInteractor implements RunInteractor {

    private final GameViewLoader loader;
    private final Transaction cancelAction;
    private final Transaction configureAction;

    public TicTacToeRunInteractor(GameViewLoader loader, Transaction cancelAction, Transaction configureAction) {
        this.loader = loader;
        this.cancelAction = cancelAction;
        this.configureAction = configureAction;
    }

    public void sendRun(RunRequest request) {
        FXBoardView boardView = new FXBoardView(BoardBoundaries.rowColumnCount);

        Board hashing = new HashingBoard();
        ListenableBoard listenableBoard = new ListenableBoard(hashing);
        ObservableBoard board = new ObservableBoard(listenableBoard);

        HybridPlayer john = makePlayer(request.getFirstPlayerType(), Mark.John, board);
        HybridPlayer haley = makePlayer(request.getSecondPlayerType(), Mark.Haley, board);
        MultiHybridPlayer multiPlayer = new MultiHybridPlayer(john);
        multiPlayer.add(haley);

        GameOverRule rule = Domain.Factory.makeGameOverRule(board);
        HybridGame game = new HybridGameImp(rule, multiPlayer);
        AsyncProcessingGameRunner runner = new AsyncProcessingGameRunner(game);

        WinningLineProvider lineProvider = Domain.Factory.makeWinningLineProvider(board);
        WinningLinePresenter winningLinePresenter = new WinningLinePresenter(boardView, lineProvider);
        board.attach(winningLinePresenter);

        InputValidator validator = new FieldIsEmptyValidator(board);
        InputAlerter alerter = new FXInputAlerter(AlertingMessages.inputAlreadyMarked);
        InputProcessor processor = Input2D.Factory.makeAlertingInputProcessor(runner, validator, alerter);
        processor = new GameOverInputProcessor(processor, rule);
        BoardViewPresenter boardPresenter = new BoardViewPresenter(board, boardView, processor);
        listenableBoard.addListener(boardPresenter);
        boardView.setDelegate(boardPresenter);

        Transaction cancelAction = this.cancelAction;
        Transaction reconfigureAction = configureAction;
        Transaction restartAction = new ResetTransaction(board, multiPlayer, runner);

        WinnerProvider winnerProvider = Domain.Factory.makeWinnerProvider(board);
        DefaultMarkToStringMapper mapper = new DefaultMarkToStringMapper(TicTacToeMessages.xWinsMessage, TicTacToeMessages.oWinsMessage);
        WinnerMessageProvider winnerMessageProvider = new WinnerMessageProviderImp(winnerProvider, mapper);
        FixedMessageProvider drawMessageProvider = new FixedMessageProvider(TicTacToeMessages.drawMessage);
        GameOverMessageProvider provider = new GameOverMessageProvider(winnerMessageProvider, drawMessageProvider);
        GameOverInteractorFacade gameOverViewInteractor = new GameOverInteractorFacade(rule, provider, cancelAction, reconfigureAction, restartAction);

        FXSynchronizingGameOverView gameOverView = new FXSynchronizingGameOverView();
        GameOverViewPresenter gameOverViewPresenter = new GameOverViewPresenter(gameOverView, gameOverViewInteractor);
        gameOverView.setDelegate(gameOverViewPresenter);
        board.attach(gameOverViewPresenter);

        GameView view = new FXTicTacToeView(boardView, gameOverView);
        loader.load(view);

        Thread worker = new Thread() {
            public void run() {
                runner.run();
            }
        };
        worker.start();
    }

    private HybridPlayer makePlayer(PlayerType type, Mark m, Board board) {
        if(type == PlayerType.InvincibleCPU)
            return new HybridPlayerAdapter(Domain.Factory.makeInvincibleComputerPlayer(m, board, new FXIODeviceFactory()));
        if(type == PlayerType.HumbleCPU)
            return new HybridPlayerAdapter(Domain.Factory.makeHumbleComputerPlayer(m, board, new FXIODeviceFactory()));

        return new HybridInputPlayerAdapter(new TicTacToeInputPlayer(m, board));
    };

}
