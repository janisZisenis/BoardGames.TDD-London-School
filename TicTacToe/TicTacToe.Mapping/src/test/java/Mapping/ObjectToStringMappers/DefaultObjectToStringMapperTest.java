package Mapping.ObjectToStringMappers;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DefaultObjectToStringMapperTest {

    private String defaultMessage = "default";
    private DefaultObjectToStringMapper sut = new DefaultObjectToStringMapper(defaultMessage);


    @Test
    void IfNoObjectsAreRegistered_ShouldMapToTheDefaultMessage() {
        Object o = new Object();

        String actual = sut.map(o);

        String expected = defaultMessage;
        assertEquals(expected, actual);
    }

    @Test
    void IfOneObjectsIsRegistered_ShouldMapToTheFirstRegisteredMessage() {
        Object o = new Object();
        sut.register(o, "First");

        String actual = sut.map(o);

        String expected = "First";
        assertEquals(expected, actual);
    }

    @Test
    void IfOneObjectsIsRegistered_ShouldMapASecondObjectToTheDefaultMessage() {
        Object o = new Object();
        Object another = new Object();
        sut.register(o, "First");

        String actual = sut.map(another);

        String expected = defaultMessage;
        assertEquals(expected, actual);
    }

}
