package Utilities.CyclicListIterator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListHasOneElement {

    private Object object = new Object();
    private List<Object> list = Arrays.asList(object);
    private CyclicListIterator<Object> sut = new CyclicListIterator<>(list);

    @Test
    void AfterCreation_ShouldReturnFirstElementAsCurrent() {
        Object actual = sut.getCurrent();

        Object expected = object;
        assertEquals(expected, actual);
    }

    @Test
    void MovedToNextOnce_ShouldReturnFirstElementAsCurrent() {
        sut.next();

        Object actual = sut.getCurrent();

        Object expected = object;
        assertEquals(expected, actual);
    }

}
