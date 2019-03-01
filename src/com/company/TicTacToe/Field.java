package com.company.TicTacToe;

public class Field {

    private final int column;
    private final int row;

    public Field(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean equals(Object o) {
        Field f = (Field) o;
        return f.row == row && f.column == column;
    }

    public int hashCode() {
        return Integer.valueOf(String.valueOf(row) + String.valueOf(column));
    }
}
