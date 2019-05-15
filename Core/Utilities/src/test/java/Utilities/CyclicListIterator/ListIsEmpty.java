package Utilities.CyclicListIterator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListIsEmpty {

    private List<Object> list = Collections.emptyList();

    @Test
    void ShouldThrowExceptionOnConstruction() {
        Executable act = () -> new CyclicListIterator<Object>(list);

        assertThrows(ListNeedsToHaveAtLeastOneObject.class, act);
    }

}
