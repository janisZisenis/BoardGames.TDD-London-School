package Mappers.MarkToStringMappers;

import Lib.Board.Mark;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarkToMessageMappingTest {

    private MarkToXOMapper sut = new MarkToXOMapper();

    @Test
    void IfJohnIsGiven_ShouldMapToX() {
        Mark m = Mark.John;

        String actual = sut.map(m);

        String expected = "X";
        assertEquals(expected, actual);
    }

    @Test
    void IfHaleyIsGiven_ShouldMapToO() {
        Mark m = Mark.Haley;

        String actual = sut.map(m);

        String expected = "O";
        assertEquals(expected, actual);
    }

}
