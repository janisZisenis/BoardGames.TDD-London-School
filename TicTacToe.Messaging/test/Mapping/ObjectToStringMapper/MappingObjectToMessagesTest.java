package Mapping.ObjectToStringMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class MappingObjectToMessagesTest {


    @Test
    void IfNoObjectIsRegistered_NoObjectShouldNotBeRegistered() {
        ObjectToMessageMapper sut = new ObjectToMessageMapper();
        Object o = new Object();

        boolean actual = sut.isMappable(o);
        assertFalse(actual);
    }

    @Test
    void IfNoObjectsAreRegistered_MappingShouldThrowException() {
        ObjectToMessageMapper sut = new ObjectToMessageMapper();
        Object o = new Object();

        Executable act = () -> { sut.map(o); };

        assertThrows(ObjectToStringMapper.ObjectNotRegisteredForMapping.class, act);
    }


    @Test
    void IfOneObjectIsRegistered_TheObjectShouldBeRegistered() {
        ObjectToMessageMapper sut = new ObjectToMessageMapper();
        Object o = new Object();
        sut.register(o, "");

        boolean actual = sut.isMappable(o);
        assertTrue(actual);
    }

    @Test
    void IfOneObjectIsRegistered_ShouldMapToItsRegisteredString() {
        ObjectToMessageMapper sut = new ObjectToMessageMapper();
        Object o = new Object();
        sut.register(o, "Object");

        String actual = sut.map(o);

        String expected = "Object";
        assertEquals(expected, actual);
    }


    @Test
    void IfOneObjectIsRegistered_ASecondObjectShouldNotBeRegistered() {
        ObjectToMessageMapper sut = new ObjectToMessageMapper();
        Object first = new Object();
        Object second = new Object();
        sut.register(first, "");

        boolean actual = sut.isMappable(second);
        assertFalse(actual);
    }

    @Test
    void IfOneObjectIsRegistered_MappingAnotherObjectShouldThrowException() {
        ObjectToMessageMapper sut = new ObjectToMessageMapper();
        Object first = new Object();
        Object second = new Object();
        sut.register(first, "");

        Executable act = () -> { sut.map(second); };

        assertThrows(ObjectToStringMapper.ObjectNotRegisteredForMapping.class, act);
    }


    @Test
    void IfTwoObjectsAreRegistered_ShouldMapTheSecondObjectToTheSecondString() {
        ObjectToMessageMapper sut = new ObjectToMessageMapper();
        Object first = new Object();
        Object second = new Object();
        sut.register(first, "First");
        sut.register(second, "Second");

        String actual = sut.map(second);

        String expected = "Second";
        assertEquals(expected, actual);
    }


    @Test
    void IfTwoObjectsAreRegistered_AThirdObjectShouldNotBeRegistered() {
        ObjectToMessageMapper sut = new ObjectToMessageMapper();
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
        ObjectToMessageMapper sut = new ObjectToMessageMapper();
        Object first = new Object();
        Object second = new Object();
        Object third = new Object();
        sut.register(first, "");
        sut.register(second, "");

        Executable act = () -> { sut.map(third); };

        assertThrows(ObjectToStringMapper.ObjectNotRegisteredForMapping.class, act);
    }

}
