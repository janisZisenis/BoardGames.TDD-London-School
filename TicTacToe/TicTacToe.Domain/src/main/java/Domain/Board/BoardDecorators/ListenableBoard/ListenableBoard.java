package Domain.Board.BoardDecorators.ListenableBoard;

import Domain.Board.Board;
import Domain.Data.Field.Field;
import Domain.Data.Mark;

import java.util.LinkedList;
import java.util.List;

public class ListenableBoard implements Board {

    private final Board board;
    private final List<BoardListener> listeners = new LinkedList<>();

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
        for(BoardListener listener : listeners)
            listener.onFieldUpdated(f);
    }

    public void addListener(BoardListener listener) {
        listeners.add(listener);
    }
}
