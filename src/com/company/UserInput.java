package com.company;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

public class UserInput {
    private int row;
    private int column;

    public UserInput(int row, int column) {
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
        UserInput in = (UserInput) o;
        return in.row == this.row
                && in.column == this.column;
    }
}
