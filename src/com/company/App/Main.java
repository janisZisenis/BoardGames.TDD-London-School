package com.company.App;

import com.company.CLI.TicTacToe.View.TicTacToeConsoleView;
import com.company.Core.GameLoop.GameLoop;
import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Board.ObservableBoard.ObservableBoard;
import com.company.TicTacToe.BoardPresenter.BoardPresenter;
import com.company.TicTacToe.BoardPresenter.WinningLineProvider;
import com.company.TicTacToe.GameEvaluator.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import com.company.TicTacToe.GameEvaluator.LineEvaluator;
import com.company.TicTacToe.GameEvaluator.GameEvaluator;
import com.company.View.MarkToXOMapper;

public class Main {

    private static ObservableBoard board;
    private static GameEvaluator gameEvaluator;
    private static MarkToXOMapper mapper;
    private static TicTacToeConsoleView view;

    private static TicTacToeConsoleView makePresentedBoardConsoleView(TicTacToeFactory factory) {
        TicTacToeConsoleView view = new TicTacToeConsoleView();
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
        view.showSalutation("Welcome to TicTacToe");
    }

    private static void showLeaveTaking() {
        String leaveTaking;
        if(gameEvaluator.hasWinner()) {
            Mark winner = gameEvaluator.getWinner();
            leaveTaking = "The Winner is " + mapper.map(winner) + "!";
        } else {
            leaveTaking = "Draw!";
        }
        view.showLeaveTaking(leaveTaking);
    }

}
