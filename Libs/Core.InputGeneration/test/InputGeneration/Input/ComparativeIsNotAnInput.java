package InputGeneration.Input;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComparativeIsNotAnInput {

    private Input sut = new Input(0, 0);
    private Object o = new Object();

    @Test
    void ShouldNotEqualTheComparative() {
        boolean actual = sut.equals(o);

        assertFalse(actual);
    }

}
