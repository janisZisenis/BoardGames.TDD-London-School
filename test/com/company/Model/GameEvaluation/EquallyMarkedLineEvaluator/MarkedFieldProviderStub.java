package com.company.Model.GameEvaluation.EquallyMarkedLineEvaluator;

import com.company.Data.Mark;
import com.company.Data.Field.Field;

import java.util.HashMap;

public class MarkedFieldProviderStub implements MarkedFieldProvider {

    HashMap<Field, Mark> marks = new HashMap<>();

    public void addMarkedField(Field f, Mark m) {
        marks.put(f, m);
    }

    public Mark getMarkAt(Field f) {
        if(isMarked(f))
            return marks.get(f);

        throw new MarkedFieldProvider.FieldIsNotMarkedException();
    }

    public boolean isMarked(Field f) {
        return marks.containsKey(f);
    }
}
