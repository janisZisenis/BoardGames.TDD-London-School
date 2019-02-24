package com.company.Core.InputGeneration;

public class Input {
    private int row;
    private int column;

    public Input(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean equals(Object o) {
        Input in = (Input) o;
        return in.row == this.row
                && in.column == this.column;
    }
}
