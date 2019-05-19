package Domain.GameEvaluation.EquallyMarkedLineEvaluator;

import Domain.Data.Field.Field;
import Domain.Data.Mark;

import java.util.HashMap;

public class MarkedFieldProviderStub extends MarkedFieldProviderDummy {

    private HashMap<Field, Mark> marks = new HashMap<>();

    public void addMarkedField(Field f, Mark m) {
        marks.put(f, m);
    }

    public Mark getMarkAt(Field f) {
        return marks.get(f);
    }

    public boolean isMarked(Field f) {
        return marks.containsKey(f);
    }
}
