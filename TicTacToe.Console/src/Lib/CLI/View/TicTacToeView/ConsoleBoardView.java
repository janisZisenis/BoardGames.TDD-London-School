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
        StringBuilder board = new StringBuilder();
        board.append("+-----+\n");

        for(int i = 0; i < rowColumn; i++)
            board.append("| ").append(getRow(i)).append(" |\n");

        board.append("+-----+");

        System.out.println(board);
    }

    private String getRow(int row) {
        StringBuilder s = new StringBuilder();

        for(int i = 0; i < rowColumn; i++) {
            Field f = new Field(i, row);
            s.append(getField(f));
        }

        return s.toString();
    }

    private boolean lineContains(Field f, Line line) {
        return f.equals(line.getFirst())
                || f.equals(line.getSecond())
                || f.equals(line.getThird());
    }

    private String getField(Field f) {
        return board.isMarked(f) ? mapper.map(board.getMarkAt(f)) : FieldSymbols.empty;
    }

    private String map(Mark m) {
        return mapper.map(m);
    }


    public void showWinningLine(Line line) {
        StringBuilder board = new StringBuilder();
        board.append("+-----+\n");

        for(int i = 0; i < rowColumn; i++)
            board.append("| " + getRow(i, line) + " |\n");

        board.append("+-----+");

        System.out.println(board);
    }

    private String getRow(int row, Line line) {
        StringBuilder s = new StringBuilder();

        for(int i = 0; i < rowColumn; i++) {
            Field f = new Field(i, row);
            String field = lineContains(f, line) ? getWinningField(f) : getField(f);
            s.append(field);
        }

        return s.toString();
    }

    private String getWinningField(Field f) {
        StringBuilder s = new StringBuilder();
        s.append(ANSI_GREEN);
        s.append(getField(f));
        s.append(ANSI_RESET);

        return s.toString();
    }

}
