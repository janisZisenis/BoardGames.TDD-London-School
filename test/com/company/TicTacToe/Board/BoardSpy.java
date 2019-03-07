package com.company.TicTacToe.Board;

import com.company.TicTacToe.Field.Field;

public class BoardSpy extends BoardStub {

    private Field field;

    public Mark getMarkAt(Field f) {
        this.field = f;
        return super.getMarkAt(f);
    }

    public Field getAskedField() {
        return field;
    }

}
