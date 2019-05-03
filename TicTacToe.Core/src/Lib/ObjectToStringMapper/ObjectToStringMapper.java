package Lib.ObjectToStringMapper;

public interface ObjectToStringMapper {
    String map(Object o);

    class ObjectNotRegisteredForMapping extends RuntimeException {}
}
