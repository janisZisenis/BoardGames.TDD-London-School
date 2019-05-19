package Input2D.Input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class InputsWithDifferentRowAndSameColumn {

    private Input sut = new Input(-1, 1);
    private Input comparative = new Input(1, 1);

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
