package com.company.TicTacToe.WinningProvider.EquallyMarkedLineEvaluator;

import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Board.Field.Field;

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
