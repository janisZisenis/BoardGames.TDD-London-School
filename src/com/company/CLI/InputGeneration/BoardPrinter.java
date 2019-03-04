package com.company.CLI.InputGeneration;

import com.company.TicTacToe.HashingBoard.HashingBoard;
import com.company.TicTacToe.Mark;
import com.company.TicTacToe.Constants.BoardBoundaries;
import com.company.TicTacToe.Constants.FieldSymbols;
import com.company.TicTacToe.Field.Field;

public class BoardPrinter {

    private final int rowColumn = BoardBoundaries.rowColumnCount;

    public void print(HashingBoard board) {
        for(int row = 0; row < rowColumn; row++) {
            printRow(row, board);
        }
    }

    private void printRow(int row, HashingBoard board) {
        for(int col = 0; col < rowColumn; col++) {
            printField(new Field(row, col), board);
        }
        System.out.println();
    }

    private void printField(Field f, HashingBoard board) {
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
