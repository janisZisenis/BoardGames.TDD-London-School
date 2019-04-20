package com.company.App;

import com.company.CLI.TicTacToe.View.BoardConsoleView;
import com.company.Core.GameLoop.GameLoop;
import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Board.ObservableBoard.ObservableBoard;
import com.company.TicTacToe.BoardPresenter.BoardPresenter;
import com.company.TicTacToe.BoardPresenter.WinningLineProvider;
import com.company.TicTacToe.WinningProvider.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import com.company.TicTacToe.WinningProvider.LineEvaluator;
import com.company.TicTacToe.WinningProvider.WinningProvider;

public class Main {

    private static ObservableBoard board;
    private static WinningProvider winnerProvider;

    private static BoardConsoleView makePresentedBoardConsoleView(TicTacToeFactory factory) {
        BoardConsoleView view = new BoardConsoleView();
        WinningLineProvider winningLineProvider = factory.makeWinningLineProvider(board);
        BoardPresenter presenter = new BoardPresenter(view, board, winningLineProvider);
        board.attach(presenter);
        return view;
    }

    private static WinningProvider makeTicTacToeWinningLineProvider(Board board) {
        TicTacToeLineProvider provider = new TicTacToeLineProvider();
        LineEvaluator evaluator = new EquallyMarkedLineEvaluator(board);
        return new WinningProvider(provider, evaluator);
    }

    public static void main(String[] args) {
        TicTacToeFactory factory = new TicTacToeFactory();

        board = factory.makeDisplayedBoard();
        winnerProvider = makeTicTacToeWinningLineProvider(board);

        BoardConsoleView view = makePresentedBoardConsoleView(factory);

        showSalutation();
        view.display(board);

        GameLoop loop = factory.makeTicTacToeGameLoop(board);
        loop.play();
        showLeaveTaking();
    }

    private static void showSalutation() {
        System.out.println("Welcome to TicTacToe");
    }

    private static void showLeaveTaking() {
        String leaveTaking;
        if(winnerProvider.hasWinner()) {
            Mark winner = winnerProvider.getWinner();
            leaveTaking = "The Winner is " + mapToString(winner) + "!";
        } else {
            leaveTaking = "Draw!";
        }
        System.out.println(leaveTaking);
    }

    private static String mapToString(Mark m) {
        return m == Mark.John ? "X" : "O";
    }

}
