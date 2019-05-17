package FXBoardGames.App;

import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Data.Mark;
import Domain.InputGeneration.GameOverInputProcessor.GameOverInputProcessor;
import Domain.InputGeneration.InputValidators.FieldIsEmptyValidator.FieldIsEmptyValidator;
import Domain.InteractiveGaming.TicTacToeInputPlayer.TicTacToeInputPlayer;
import FXView.FXBoardView;
import FXView.FXIODeviceFactory;
import FXView.FXInputAlerter;
import FXBoardGames.View.FXTicTacToeView;
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
import Utilities.Transaction.Transaction;

public class TicTacToeAction implements Transaction {

    private final FXTicTacToeView tictactoe;
    private final ListenableBoard board;
    private final FXBoardView boardView;
    private final PlayerTypeProvider provider;

    public TicTacToeAction(FXTicTacToeView tictactoe, ListenableBoard board, FXBoardView boardView, PlayerTypeProvider provider) {
        this.tictactoe = tictactoe;
        this.board = board;
        this.boardView = boardView;
        this.provider = provider;
    }

    public void execute() {
        tictactoe.showBoard();

        HybridPlayer john = makePlayer(provider.getFirst(), Mark.John);
        HybridPlayer haley = makePlayer(provider.getSecond(), Mark.Haley);
        MultiHybridPlayer multiPlayer = new MultiHybridPlayer(john);
        multiPlayer.add(haley);

        GameOverRule rule = Domain.Factory.makeGameOverRule(board);
        HybridGame game = new HybridGameImp(rule, multiPlayer);
        HybridGameRunner runner = new HybridGameRunner(game);

        InputValidator validator = new FieldIsEmptyValidator(board);
        InputAlerter alerter = new FXInputAlerter(AlertingMessages.inputAlreadyMarked);
        InputProcessor processor = InputGeneration.Factory.makeAlertingInputProcessor(runner, validator, alerter);
        processor = new GameOverInputProcessor(processor, rule);
        BoardViewPresenter boardPresenter = new BoardViewPresenter(board, boardView, processor);
        board.addListener(boardPresenter);
        boardView.setDelegate(boardPresenter);

        runner.run();
    }

    private HybridPlayer makePlayer(PlayerType type, Mark m) {
        if(type == PlayerType.Human)
            return new HybridInputPlayerAdapter(new TicTacToeInputPlayer(m, board));
        if(type == PlayerType.Humble)
            return new HybridPlayerAdapter(Domain.Factory.makeHumbleComputerPlayer(m, board, new FXIODeviceFactory()));

        return new HybridPlayerAdapter(Domain.Factory.makeInvincibleComputerPlayer(m, board, new FXIODeviceFactory()));
    };

}
