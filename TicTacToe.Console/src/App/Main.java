package App;

import Lib.CLI.View.TicTacToeView.TicTacToeConsoleView;
import Lib.Model.Board.Board;
import Lib.Model.Board.ObservableBoard.ObservableBoard;
import Lib.Model.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import Lib.Model.GameEvaluation.GameEvaluator.GameEvaluator;
import Lib.Model.GameEvaluation.GameEvaluator.LineEvaluator;
import Lib.Model.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import Lib.Model.GameLoop.GameLoop;
import Lib.Presentation.BoardPresenter.BoardPresenter;
import Lib.Presentation.BoardPresenter.WinningLineProvider;
import Lib.Presentation.LeaveTaker.LeaveTaker;
import Lib.Presentation.MarkToStringMapper.MarkToStringMapper;
import Lib.Presentation.MarkToStringMapper.MarkToXOMapper;

import java.util.HashMap;

public class Main {

    private static ObservableBoard board;
    private static GameEvaluator gameEvaluator;
    private static TicTacToeConsoleView view;
    private static HashMap<Object, String> mapping = new HashMap<>();

    private static TicTacToeConsoleView makePresentedBoardConsoleView(TicTacToeFactory factory) {
        MarkToStringMapper mapper = new MarkToXOMapper();
        TicTacToeConsoleView view = new TicTacToeConsoleView(mapper);
        WinningLineProvider winningLineProvider = factory.makeWinningLineProvider(board);
        BoardPresenter presenter = new BoardPresenter(view, board, winningLineProvider);
        board.attach(presenter);
        return view;
    }

    private static GameEvaluator makeTicTacToeWinningLineProvider(Board board) {
        HumbleLineProvider provider = new HumbleLineProvider();
        LineEvaluator evaluator = new EquallyMarkedLineEvaluator(board);
        return new GameEvaluator(provider, evaluator);
    }

    public static void main(String[] args) {
        TicTacToeFactory factory = new TicTacToeFactory();

        board = factory.makeDisplayedBoard();
        gameEvaluator = makeTicTacToeWinningLineProvider(board);
        view = makePresentedBoardConsoleView(factory);
        LeaveTaker leaveTaker = new LeaveTaker(gameEvaluator, view);

        showSalutation();
        view.display(board);

        GameLoop loop = factory.makeGameLoop(board);
        loop.run();

        leaveTaker.showLeaveTaking();
    }

    private static void showSalutation() {
        view.showSalutation();
    }

}
