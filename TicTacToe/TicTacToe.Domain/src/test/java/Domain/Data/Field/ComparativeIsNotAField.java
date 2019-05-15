package Domain.Data.Field;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ComparativeIsNotAField {

    private Field sut = new Field(0, 0);
    private Object comparative = new Object();

    @Test
    void ShouldNotEqualTheComparative() {
        boolean actual = sut.equals(comparative);

        assertFalse(actual);
    }

}
