package com.company.TicTacToe.ObservableBoard;

import com.company.TicTacToe.Field.Field;

public class BoardDummy implements Board {

    public boolean isEmpty(Field f) {
        return false;
    }

    public void mark(Field f, Mark m) {

    }

    public Mark getMarkAt(Field f) {
        return null;
    }

    public int getMarkedFieldCount() {
        return 0;
    }

}
