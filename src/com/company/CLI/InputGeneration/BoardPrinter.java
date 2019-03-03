package com.company.CLI.InputGeneration;

import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Constants.BoardBoundaries;
import com.company.TicTacToe.Constants.FieldSymbols;
import com.company.TicTacToe.Field.Field;

public class BoardPrinter {

    private final int lower = BoardBoundaries.lower;
    private final int upper = BoardBoundaries.upper;

    public void print(Board board) {
        for(int row = lower; row <= upper; row++) {
            printRow(row, board);
        }
    }

    private void printRow(int row, Board board) {
        for(int col = lower; col <= upper; col++) {
            printField(new Field(row, col), board);
        }
        System.out.println();
    }

    private void printField(Field f, Board board) {
        String s = FieldSymbols.empty;
        if(!board.isEmpty(f)) {
            s = map(board.getMarkAt(f));
        }
        System.out.print(s);
    }

    private String map(Mark m) {
        return (m == Mark.John) ? FieldSymbols.john : FieldSymbols.haley;
    }

}
