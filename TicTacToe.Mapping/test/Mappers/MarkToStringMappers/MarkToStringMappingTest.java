package Mappers.MarkToStringMappers;

import Board.Mark;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarkToStringMappingTest {

    private String johnMessage = "John";
    private String haleyMessage = "Haley";
    private MarkToMessageMapper sut = new MarkToMessageMapper(johnMessage, haleyMessage);

    @Test
    void IfJohnIsGiven_ShouldMapToJohnsMessage() {
        Mark m = Mark.John;

        String actual = sut.map(m);

        String expected = johnMessage;
        assertEquals(expected, actual);
    }

    @Test
    void IfHaleyIsGiven_ShouldMapToTheHaleysMessage() {
        Mark m = Mark.Haley;

        String actual = sut.map(m);

        String expected = haleyMessage;
        assertEquals(expected, actual);
    }

}
