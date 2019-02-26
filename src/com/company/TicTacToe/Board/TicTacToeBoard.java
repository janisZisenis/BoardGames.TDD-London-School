package com.company.TicTacToe.Board;

import com.company.TicTacToe.IsOnBoardValidator.FieldExistsProvider;
import com.company.TicTacToe.Field;
import com.company.TicTacToe.Player.MarkFieldService;

import java.util.HashMap;

public class TicTacToeBoard implements FieldExistsProvider, MarkFieldService {

    private HashMap<Field, Player> fields = new HashMap<Field, Player>();

    public boolean exists(Field f) {
        int row = f.getRow();
        int col = f.getColumn();

        if(isOutOfBounds(row) || isOutOfBounds(col))
            return false;

        return true;
    }

    public boolean isEmpty(Field f) {
        throwIfFieldDoesNotExist(f);
        return fieldWasNotMarked(f);
    }

    public void mark(Field f, Player m) {
        throwIfFieldDoesNotExist(f);
        store(f, m);
    }

    public Player getMarkAt(Field f) {
        throwIfFieldDoesNotExist(f);

        if(fields.keySet().contains(f))
            return fields.get(f);

        throw new FieldIsEmpty();
    }


    private boolean isOutOfBounds(int pos) {
        return pos < 0 || pos > 2;
    }

    private boolean fieldWasNotMarked(Field f) {
        return !fields.keySet().contains(f);
    }

    private void throwIfFieldDoesNotExist(Field f) {
        if(!exists(f))
            throw new FieldDoesNotExist();
    }


    private void store(Field f, Player m) {
        fields.put(f, m);
    }

    public class FieldDoesNotExist extends RuntimeException {}

    public class FieldIsEmpty extends RuntimeException {}
}
