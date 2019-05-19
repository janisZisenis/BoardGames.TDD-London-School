package Input2D.Input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class ComparativeIsNotAnInput {

    private Input sut = new Input(0, 0);
    private Object comparative = new Object();

    @Test
    void ShouldNotEqualTheComparative() {
        boolean actual = sut.equals(comparative);

        assertFalse(actual);
    }

}
