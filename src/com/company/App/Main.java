package com.company.App;

import com.company.CLI.TicTacToe.View.BoardConsoleView;
import com.company.Core.GameLoop.GameLoop;
import com.company.TicTacToe.Board.Field.Field;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Board.ObservableBoard.ObservableBoard;
import com.company.TicTacToe.BoardPresenter.BoardPresenter;
import com.company.TicTacToe.BoardPresenter.WinningLineProvider;
import com.company.TicTacToe.GameOverRules.WinningLineRule.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import com.company.TicTacToe.GameOverRules.WinningLineRule.LineEvaluator;
import com.company.TicTacToe.Line;

public class Main {

    private static TicTacToeLineProvider provider;
    private static LineEvaluator evaluator;
    private static ObservableBoard board;

    private static BoardConsoleView makePresentedBoardConsoleView(TicTacToeFactory factory) {
        BoardConsoleView view = new BoardConsoleView();
        WinningLineProvider winningLineProvider = factory.makeWinningLineProvider(board);
        BoardPresenter presenter = new BoardPresenter(view, board, winningLineProvider);
        board.attach(presenter);
        return view;
    }

    public static void main(String[] args) {
        TicTacToeFactory factory = new TicTacToeFactory();

        board = factory.makeDisplayedBoard();
        provider = new TicTacToeLineProvider();
        evaluator = new EquallyMarkedLineEvaluator(board);

        BoardConsoleView view = makePresentedBoardConsoleView(factory);
        view.display(board);

        showSalutation(view);
        GameLoop loop = factory.makeTicTacToeGameLoop(board);
        loop.play();
        showLeaveTaking();
    }

    private static void showSalutation(BoardConsoleView view) {
        System.out.println("Welcome to TicTacToe");
    }

    private static void showLeaveTaking() {
        String leaveTaking;
        if(hasWinner()) {
            Mark winner = getWinner();
            leaveTaking = "The Winner is " + mapToString(winner) + "!";
        } else {
            leaveTaking = "Draw!";
        }
        System.out.println(leaveTaking);
    }

    private static boolean hasWinner() {
        for(int i = 0; i < provider.getLineCount(); i++) {
            Line line = provider.getLine(i);
            if(evaluator.isWinningLine(line)) {
                return true;
            }
        }

        return false;
    }

    private static Mark getWinner() {
        for(int i = 0; i < provider.getLineCount(); i++) {
            Line line = provider.getLine(i);
            if(evaluator.isWinningLine(line)) {
                Field f = line.getFirst();
                return board.getMarkAt(f);
            }
        }

        return null;
    }

    private static String mapToString(Mark m) {
        return m == Mark.John ? "X" : "O";
    }

}
