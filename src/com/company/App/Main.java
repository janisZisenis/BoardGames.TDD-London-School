package com.company.App;

import com.company.CLI.View.TicTacToeView.TicTacToeConsoleView;
import com.company.Model.Board.Board;
import com.company.Model.Board.ObservableBoard.ObservableBoard;
import com.company.Model.GameEvaluation.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import com.company.Model.GameEvaluation.GameEvaluator.GameEvaluator;
import com.company.Model.GameEvaluation.GameEvaluator.LineEvaluator;
import com.company.Model.GameEvaluation.HumbleLineProvider.HumbleLineProvider;
import com.company.Model.GameLoop.GameLoop;
import com.company.Presentation.BoardPresenter.BoardPresenter;
import com.company.Presentation.BoardPresenter.WinningLineProvider;
import com.company.Presentation.LeaveTaker.LeaveTaker;
import com.company.Presentation.MarkToStringMapper.MarkToStringMapper;
import com.company.Presentation.MarkToStringMapper.MarkToXOMapper;

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
