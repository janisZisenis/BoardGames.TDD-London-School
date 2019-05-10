package Domain.Board;

import Domain.Data.Field.Field;
import Domain.Data.Mark;

import java.util.Arrays;
import java.util.HashMap;

public class BoardStub extends BoardDummy {

    private Field[] empty = {};
    private Field[] marked = {};
    private int count;
    private HashMap<Field, Mark> marks = new HashMap<>();

    public void setEmptyFields(Field[] empty) {
        this.empty = empty;
    }

    public boolean isEmpty(Field f) {
        return Arrays.asList(empty).contains(f);
    }

    public void setMarkedFields(Field[] marked) {
        this.marked = marked;
    }

    public boolean isMarked(Field f) {
        return Arrays.asList(marked).contains(f);
    }

    public void setMarkedFieldCount(int count) {
        this.count = count;
    }

    public int getMarkedFieldCount() {
        return this.count;
    }

    public void setMarkOnField(Mark m, Field f) {
        marks.put(f, m);
    }

    public Mark getMarkAt(Field f) {
        return marks.get(f);
    }

}
