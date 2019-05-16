package Domain.Data.Field;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FieldsWithSameRowAndSameColumn {

    private Field sut = new Field(-1, 1);
    private Field comparative = new Field(-1, 1);

    @Test
    void ShouldEqualEachOther() {
        boolean actual = sut.equals(comparative);

        assertTrue(actual);
    }

    @Test
    void ShouldHaveTheSameHashCode() {
        int actual = sut.hashCode();

        int expected = comparative.hashCode();
        assertEquals(expected, actual);
    }
}
