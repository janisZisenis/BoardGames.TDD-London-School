package Mappers.ObjectToStringMappers;

import Mappers.ObjectToStringMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class MappingObjectToMessagesTest {


    private ObjectToMessageMapper sut = new ObjectToMessageMapper();

    @Test
    void IfNoObjectIsRegistered_NoObjectShouldBeMappable() {
        Object o = new Object();

        boolean actual = sut.isMappable(o);
        assertFalse(actual);
    }

    @Test
    void IfNoObjectsAreRegistered_MappingShouldThrowException() {
        Object o = new Object();

        Executable act = () -> { sut.map(o); };

        assertThrows(ObjectToStringMapper.ObjectNotMappableToString.class, act);
    }


    @Test
    void IfOneObjectIsRegistered_TheObjectShouldBeMappable() {
        Object o = new Object();
        sut.register(o, "");

        boolean actual = sut.isMappable(o);
        assertTrue(actual);
    }

    @Test
    void IfOneObjectIsRegistered_ShouldMapToItsRegisteredString() {
        Object o = new Object();
        sut.register(o, "Object");

        String actual = sut.map(o);

        String expected = "Object";
        assertEquals(expected, actual);
    }


    @Test
    void IfOneObjectIsRegistered_ASecondObjectShouldNotBeMappable() {
        Object first = new Object();
        Object second = new Object();
        sut.register(first, "");

        boolean actual = sut.isMappable(second);
        assertFalse(actual);
    }

    @Test
    void IfOneObjectIsRegistered_MappingAnotherObjectShouldThrowException() {
        Object first = new Object();
        Object second = new Object();
        sut.register(first, "");

        Executable act = () -> { sut.map(second); };

        assertThrows(ObjectToStringMapper.ObjectNotMappableToString.class, act);
    }


    @Test
    void IfTwoObjectsAreRegistered_ShouldMapTheSecondObjectToTheSecondString() {
        Object first = new Object();
        Object second = new Object();
        sut.register(first, "First");
        sut.register(second, "Second");

        String actual = sut.map(second);

        String expected = "Second";
        assertEquals(expected, actual);
    }


    @Test
    void IfTwoObjectsAreRegistered_AThirdObjectShouldNotBeMappable() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        sut.register(first, "");
        sut.register(second, "");

        boolean actual = sut.isMappable(third);
        assertFalse(actual);
    }

    @Test
    void IfTwoObjectAreRegistered_MappingThirdObjectShouldThrowException() {
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        sut.register(first, "");
        sut.register(second, "");

        Executable act = () -> { sut.map(third); };

        assertThrows(ObjectToStringMapper.ObjectNotMappableToString.class, act);
    }

}
