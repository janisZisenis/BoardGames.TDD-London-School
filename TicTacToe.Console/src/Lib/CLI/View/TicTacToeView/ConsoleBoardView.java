package Lib.CLI.View.TicTacToeView;

import Lib.Data.BoardBoundaries;
import Lib.Data.Field.Field;
import Lib.Data.Line;
import Lib.Data.Mark;
import Lib.Model.Board.ReadOnlyBoard;
import Lib.Model.BoardRenderer.BoardView;
import Lib.Presentation.MarkToStringMapper.MarkToStringMapper;

public class ConsoleBoardView implements BoardView {

    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RESET = "\u001B[0m";
    private final int rowColumn = BoardBoundaries.rowColumnCount;
    private final MarkToStringMapper mapper;
    private final ReadOnlyBoard board;

    public ConsoleBoardView(ReadOnlyBoard board, MarkToStringMapper mapper) {
        this.board = board;
        this.mapper = mapper;
    }


    public void showBoard() {
        System.out.println();
        for(int row = 0; row < rowColumn; row++) {
            printRow(row);
        }
        System.out.println();
    }

    private void printRow(int row) {
        for(int col = 0; col < rowColumn; col++) {
            printField(new Field(row, col));
        }
        System.out.println();
    }

    private void printField(Field f) {
        String s = FieldSymbols.empty;

        if(board.isMarked(f))
            s = map(board.getMarkAt(f));

        System.out.print(s);
    }

    public void showWinningLine(Line line) {
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

    private String map(Mark m) {
        return mapper.map(m);
    }

}
