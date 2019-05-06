package InputGeneration.Input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class InputsWithSameRowAndDifferentColumn {

    private Input sut = new Input(-1, 1);
    private Input input = new Input(-1, -1);

    @Test
    void TheyShouldNotEqualEachOther() {
        boolean actual = sut.equals(input);

        assertFalse(actual);
    }

    @Test
    void TheyShouldNotHaveTheSameHashCode() {
        int actual = sut.hashCode();

        int unexpected = input.hashCode();
        assertNotEquals(unexpected, actual);
    }
}
