package com.company.TicTacToe.Board;

import com.company.TicTacToe.Field.Field;

import java.util.Arrays;

public class BoardStub extends BoardDummy {

    private Field[] empty = {};
    private int count;
    private Mark mark;

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

    public void setMark(Mark mark) {
        this.mark = mark;
    }

    public Mark getMarkAt(Field f) {
        return mark;
    }
}
