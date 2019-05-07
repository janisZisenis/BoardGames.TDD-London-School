package Domain.Data.Field;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DifferentFieldsWithTheSameSumOfRowAndColumn {

    private Field sut = new Field(1, -1);
    private Field comparative = new Field(-1, 1);

    @Test
    void ShouldNotHaveTheSameHashCode() {
        int actual = sut.hashCode();

        int unexpected = comparative.hashCode();
        assertNotEquals(unexpected, actual);
    }

}
