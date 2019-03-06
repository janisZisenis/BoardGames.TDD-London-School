package com.company.TicTacToe.ObservableBoard;

import com.company.TicTacToe.Field.Field;

import java.util.Arrays;

public class BoardStub extends BoardDummy {

    private Field[] empty = {};
    private int count;

    public void setEmptyFields(Field[] empty) {
        this.empty = empty;
    }

    public boolean isEmpty(Field f) {
        return Arrays.asList(empty).contains(f);
    }

    public void setMarkedFieldCount(int count) {
        this.count = count;
    }

    public int getMarkedFieldCount() {
        return this.count;
    }
}
