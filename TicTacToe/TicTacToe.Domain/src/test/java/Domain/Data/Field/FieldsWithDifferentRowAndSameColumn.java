package Domain.Data.Field;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class FieldsWithDifferentRowAndSameColumn {

    private Field sut = new Field(-1, 1);
    private Field comparative = new Field(1, 1);

    @Test
    void ShouldNotEqualEachOther() {
        boolean actual = sut.equals(comparative);

        assertFalse(actual);
    }

    @Test
    void ShouldNotHaveTheSameHashCode() {
        int actual = sut.hashCode();

        int unexpected = comparative.hashCode();
        assertNotEquals(unexpected, actual);
    }
}
