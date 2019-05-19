package Domain.Board;

import Domain.Data.Field.Field;
import Domain.Data.Mark;

public class BoardDummy implements Board {

    public boolean isEmpty(Field f) {
        return false;
    }

    public boolean isMarked(Field f) {
        return false;
    }

    public void mark(Field f, Mark m) {

    }

    public Mark getMarkAt(Field f) {
        return null;
    }

    public int getMarkedFieldCount() {
        return 0;
    }

    public void clear() {

    }

}
