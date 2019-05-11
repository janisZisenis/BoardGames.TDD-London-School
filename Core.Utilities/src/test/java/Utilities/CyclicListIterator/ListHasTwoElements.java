package Utilities.CyclicListIterator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListHasTwoElements {

    private Object first = new Object();
    private Object second = new Object();
    private List<Object> list = List.of(first, second);
    private CyclicIterator<Object> sut = new CyclicIterator<>(list);

    @Test
    void MovedToNextOnce_ShouldReturnSecondElementAsCurrent() {
        sut.next();

        Object actual = sut.getCurrent();

        Object expected = second;
        assertEquals(expected, actual);
    }

}
