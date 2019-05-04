package Lib.Board;

import Data.Field.Field;

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

}
