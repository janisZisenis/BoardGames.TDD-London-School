package Gaming.Input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class DifferentInputsWithTheSameSumOfRowAndColumn {

    private Input sut = new Input(1, -1);
    private Input input = new Input(-1, 1);

    @Test
    void ShouldNotHaveTheSameHashCode() {
        int actual = sut.hashCode();

        int unexpected = input.hashCode();
        assertNotEquals(unexpected, actual);
    }

}
