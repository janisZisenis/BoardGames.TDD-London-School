package Domain.Board.Api;

import Data.Field.Field;
import Domain.Board.Mark;

import java.util.HashMap;

public class MarkedFieldProviderStub implements MarkedFieldProvider {

    private HashMap<Field, Mark> marks = new HashMap<>();

    public void addMarkedField(Field f, Mark m) {
        marks.put(f, m);
    }

    public Mark getMarkAt(Field f) {
        if(isMarked(f))
            return marks.get(f);

        throw new FieldIsNotMarked();
    }

    public boolean isMarked(Field f) {
        return marks.containsKey(f);
    }
}
