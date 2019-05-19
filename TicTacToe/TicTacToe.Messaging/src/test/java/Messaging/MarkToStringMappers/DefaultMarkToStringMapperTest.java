package Messaging.MarkToStringMappers;

import Domain.Data.Mark;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultMarkToStringMapperTest {

    private String johnsMessage = "John";
    private String haleysMessage = "Haley";
    private DefaultMarkToStringMapper sut = new DefaultMarkToStringMapper(johnsMessage, haleysMessage);

    @Test
    void IfJohnIsGiven_ShouldMapToJohnsMessage() {
        Mark m = Mark.John;

        String actual = sut.map(m);

        String expected = johnsMessage;
        assertEquals(expected, actual);
    }

    @Test
    void IfHaleyIsGiven_ShouldMapToHaleysMessage() {
        Mark m = Mark.Haley;

        String actual = sut.map(m);

        String expected = haleysMessage;
        assertEquals(expected, actual);
    }

}
