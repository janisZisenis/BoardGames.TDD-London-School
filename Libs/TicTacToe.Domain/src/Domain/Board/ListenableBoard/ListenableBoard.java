package Domain.Board.ListenableBoard;

import Domain.Data.Field.Field;
import Domain.Board.Board;
import Domain.Data.Mark;

public class ListenableBoard implements Board {

    private final Board board;
    private BoardListener listener;

    public ListenableBoard(Board board) {
        this.board = board;
    }

    public boolean isEmpty(Field f) {
        return board.isEmpty(f);
    }

    public boolean isMarked(Field f) {
        return board.isMarked(f);
    }

    public Mark getMarkAt(Field f) {
        return board.getMarkAt(f);
    }

    public int getMarkedFieldCount() {
        return board.getMarkedFieldCount();
    }

    public void mark(Field f, Mark m) {
        board.mark(f, m);
        notify(f);
    }

    private void notify(Field f) {
        if(listener != null)
            listener.updateField(f);
    }

    public void setListener(BoardListener listener) {
        this.listener = listener;
    }
}
