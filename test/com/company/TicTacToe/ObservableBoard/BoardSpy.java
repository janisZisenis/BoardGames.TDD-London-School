package com.company.TicTacToe.ObservableBoard;

import com.company.TicTacToe.Field.Field;
import com.company.TicTacToe.Mark;

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
