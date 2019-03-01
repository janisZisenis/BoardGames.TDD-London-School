package com.company.TicTacToe.Board;

import com.company.TicTacToe.Field;
import com.company.TicTacToe.FieldIsEmptyValidator.FieldIsEmptyProvider;
import com.company.TicTacToe.Player.MarkFieldService;

import java.util.HashMap;

public class TicTacToeBoard implements MarkFieldService, FieldIsEmptyProvider {
    private final HashMap<Field, Mark> fields = new HashMap<Field, Mark>();

    public boolean isEmpty(Field f) {
        return !fields.keySet().contains(f);
    }

    public void mark(Field f, Mark m) {
        fields.put(f, m);
    }

    public Mark getMarkAt(Field f) {
        throwIfFieldIsEmpty(f);

        return fields.get(f);
    }

    private void throwIfFieldIsEmpty(Field f) {
        if(isEmpty(f))
            throw new FieldIsEmpty();
    }

    public class FieldIsEmpty extends RuntimeException {}

}
