package com.company.TicTacToe.HashingBoard;

import com.company.TicTacToe.Board;
import com.company.TicTacToe.Field.Field;
import com.company.TicTacToe.Mark;

import java.util.HashMap;

public class HashingBoard implements Board {
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

    public int getMarkedFieldCount() {
        return fields.size();
    }

    private void throwIfFieldIsEmpty(Field f) {
        if(isEmpty(f))
            throw new Board.FieldIsEmpty();
    }

}
