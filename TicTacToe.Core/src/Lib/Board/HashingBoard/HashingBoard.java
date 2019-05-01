package Lib.Board.HashingBoard;

import Lib.Board.Board;
import Lib.Data.Field.Field;
import Lib.Data.Mark;

import java.util.HashMap;

public class HashingBoard implements Board {
    private final HashMap<Field, Mark> fields = new HashMap<>();

    public boolean isEmpty(Field f) {
        return !fields.containsKey(f);
    }

    public void mark(Field f, Mark m) {
        fields.put(f, m);
    }

    public Mark getMarkAt(Field f) {
        throwIfFieldIsEmpty(f);

        return fields.get(f);
    }

    public int getMarkedFieldCount() {
        return fields.size();
    }

    private void throwIfFieldIsEmpty(Field f) {
        if(isEmpty(f))
            throw new FieldIsNotMarked();
    }

    public boolean isMarked(Field f) {
        if(fields.containsKey(f))
            return true;
        return false;
    }
}
