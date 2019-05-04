package Data.Line;

import Data.Field.Field;

public class Line {

    private final Field first;
    private final Field second;
    private final Field third;

    public Line(Field first, Field second, Field third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public Field getThird() {
        return third;
    }

    public Field getSecond() {
        return second;
    }

    public Field getFirst() {
        return first;
    }
}
