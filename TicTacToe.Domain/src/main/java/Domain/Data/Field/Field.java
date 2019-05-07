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
        return isAnInput(o) && hasSameRowAndColumn((Field) o);
    }

    private boolean hasSameRowAndColumn(Field f) {
        return f.row == row && f.column == column;
    }

    private boolean isAnInput(Object o) {
        return o instanceof Field;
    }

    public int hashCode() {
        return ("row: " + row + " column: " + column).hashCode();
    }

}
