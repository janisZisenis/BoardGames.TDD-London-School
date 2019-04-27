package Lib.Data.Field;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FieldsWithSameRowAndSameColumn {

    private Field sut = new Field(-1, 1);
    private Field field = new Field(-1, 1);

    @Test
    void TheFieldsShouldNotEqualEachOther() {
        boolean actual = sut.equals(field);

        assertTrue(actual);
    }

    @Test
    void IfTwoFieldsHaveSameRowAndSameColumn_TheyShouldHaveTheSameHashCode() {
        int actual = sut.hashCode();

        int expected = field.hashCode();
        assertEquals(expected, actual);
    }
}
