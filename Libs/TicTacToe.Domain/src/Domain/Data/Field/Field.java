package Domain.Data.Field;

public class Field {

    private final int row;
    private final int column;

    public Field(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public boolean equals(Object o) {
        Field f = (Field)o;
        return f.row == row && f.column == column;
    }

    public int hashCode() {
        return ("row: " + row + " column: " + column).hashCode();
    }

}
