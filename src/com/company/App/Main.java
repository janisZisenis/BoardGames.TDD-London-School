package com.company.App;

import com.company.CLI.TicTacToe.View.BoardConsoleView;
import com.company.Core.GameLoop.GameLoop;
import com.company.TicTacToe.Board.Field.Field;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Board.ObservableBoard.ObservableBoard;
import com.company.TicTacToe.GameOverRules.WinningLineRule.EquallyMarkedLineEvaluator.EquallyMarkedLineEvaluator;
import com.company.TicTacToe.Line;

public class Main {

    private static TicTacToeLineProvider provider;
    private static EquallyMarkedLineEvaluator evaluator;
    private static ObservableBoard board;

    public static void main(String[] args) {
        TicTacToeFactory factory = new TicTacToeFactory();
        board = factory.makeDisplayedBoard();

        provider = new TicTacToeLineProvider();
        evaluator = new EquallyMarkedLineEvaluator(board);

        BoardConsoleView view = new BoardConsoleView();
        //BoardEvaluator evaluator = new BoardEvaluator(board, provider);
        //BoardPresenter presenter = new BoardPresenter(view, board);
        //board.attach(presenter);
        view.display(board);

        System.out.println("Welcome to TicTacToe");

        GameLoop loop = factory.makeTicTacToeGameLoop(board);
        loop.play();

        for(int i = 0; i < provider.getLineCount(); i++) {
            Line line = provider.getLine(i);
            if(evaluator.isWinningLine(line))
                view.display(board, line);
        }

        showLeaveTaking();
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
