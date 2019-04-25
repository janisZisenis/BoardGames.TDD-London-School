package com.company.App;

import com.company.CLI.TicTacToe.View.TicTacToeConsoleView;
import com.company.Core.GameLoop.GameLoop;
import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Board.ObservableBoard.ObservableBoard;
import com.company.TicTacToe.BoardPresenter.BoardPresenter;
import com.company.TicTacToe.BoardPresenter.WinningLineProvider;
import com.company.TicTacToe.GameEvaluator.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import com.company.TicTacToe.GameEvaluator.GameEvaluator;
import com.company.TicTacToe.GameEvaluator.LineEvaluator;
import com.company.View.MarkToStringMapper;
import com.company.View.MarkToXOMapper;

public class Main {

    private static ObservableBoard board;
    private static GameEvaluator gameEvaluator;
    private static MarkToXOMapper mapper;
    private static TicTacToeConsoleView view;

    private static TicTacToeConsoleView makePresentedBoardConsoleView(TicTacToeFactory factory) {
        MarkToStringMapper mapper = new MarkToXOMapper();
        TicTacToeConsoleView view = new TicTacToeConsoleView(mapper);
        WinningLineProvider winningLineProvider = factory.makeWinningLineProvider(board);
        BoardPresenter presenter = new BoardPresenter(view, board, winningLineProvider);
        board.attach(presenter);
        return view;
    }

    private static GameEvaluator makeTicTacToeWinningLineProvider(Board board) {
        TicTacToeLineProvider provider = new TicTacToeLineProvider();
        LineEvaluator evaluator = new EquallyMarkedLineEvaluator(board);
        return new GameEvaluator(provider, evaluator);
    }

    public static void main(String[] args) {
        TicTacToeFactory factory = new TicTacToeFactory();

        board = factory.makeDisplayedBoard();
        gameEvaluator = makeTicTacToeWinningLineProvider(board);
        mapper = new MarkToXOMapper();
        view = makePresentedBoardConsoleView(factory);

        showSalutation();
        view.display(board);

        GameLoop loop = factory.makeGameLoop(board);
        loop.play();
        showLeaveTaking();
    }

    private static void showSalutation() {
        view.showSalutation();
    }

    private static void showLeaveTaking() {
        if(gameEvaluator.hasWinner()) {
            Mark winner = gameEvaluator.getWinner();
            view.showWinner(winner);
        } else {
            view.showDraw();
        }
    }

}
