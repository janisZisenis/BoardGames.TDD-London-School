package com.company.CLI.TicTacToe.View;

import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Constants.BoardBoundaries;
import com.company.TicTacToe.Board.Field.Field;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Board.ObservableBoard.Observer;

public class BoardConsoleView implements Observer {

    private final int rowColumn = BoardBoundaries.rowColumnCount;
    private final Board board;

    public BoardConsoleView(Board board) {
        this.board = board;
        print();
    }

    public void print() {
        for(int row = 0; row < rowColumn; row++) {
            printRow(row);
        }
    }

    private void printRow(int row) {
        for(int col = 0; col < rowColumn; col++) {
            printField(new Field(row, col));
        }
        System.out.println();
    }

    private void printField(Field f) {
        String s = FieldSymbols.empty;

        if(!board.isEmpty(f))
            s = map(board.getMarkAt(f));

        System.out.print(s);
    }

    private String map(Mark m) {
        return (m == Mark.John) ? FieldSymbols.john : FieldSymbols.haley;
    }

    public void update() {
        print();
    }
}
