package Lib.ObjectToStringMapper;

public interface ObjectToStringMapper {
    String map(Object o);
    boolean isMappable(Object player);

    class ObjectNotRegisteredForMapping extends RuntimeException {}
}
