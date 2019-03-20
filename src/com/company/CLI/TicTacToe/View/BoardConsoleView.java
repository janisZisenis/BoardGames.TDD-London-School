package com.company.CLI.TicTacToe.View;

import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.Field.Field;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.BoardPresenter.BoardView;
import com.company.TicTacToe.Constants.BoardBoundaries;
import com.company.TicTacToe.Line;

public class BoardConsoleView implements BoardView {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    private final int rowColumn = BoardBoundaries.rowColumnCount;

    public BoardConsoleView() {}

    public void display(Board board) {
        for(int row = 0; row < rowColumn; row++) {
            printRow(row, board);
        }
    }

    private void printRow(int row, Board board) {
        for(int col = 0; col < rowColumn; col++) {
            printField(new Field(row, col), board);
        }
        System.out.println();
    }

    private void printField(Field f, Board board) {
        String s = FieldSymbols.empty;

        if(!board.isEmpty(f))
            s = map(board.getMarkAt(f));

        System.out.print(s);
    }

    private String map(Mark m) {
        return (m == Mark.John) ? FieldSymbols.john : FieldSymbols.haley;
    }

    public void display(Board board, Line line) {
        for(int row = 0; row < rowColumn; row++) {
            for(int col = 0; col < rowColumn; col++) {
                Field f = new Field(row, col);
                String s = FieldSymbols.empty;

                if(board.isMarked(f))
                    s = map(board.getMarkAt(f));

                if(lineContains(f, line))
                    s = ANSI_GREEN + s + ANSI_RESET;

                System.out.print(s);
            }
            System.out.println();
        }
    }

    private boolean lineContains(Field f, Line line) {
        return f.equals(line.getFirst())
                || f.equals(line.getSecond())
                || f.equals(line.getThird());
    }

}
