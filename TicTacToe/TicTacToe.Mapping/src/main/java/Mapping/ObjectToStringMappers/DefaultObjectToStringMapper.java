package Mapping.ObjectToStringMappers;

import Mapping.ObjectToStringMapper;

import java.util.HashMap;

public class DefaultObjectToStringMapper implements ObjectToStringMapper {

    private final String defaultMessage;
    private HashMap<Object, String> messages = new HashMap<>();

    public DefaultObjectToStringMapper(String defaultMessage) {
        this.defaultMessage = defaultMessage;
    }

    public String map(Object o) {
        return messages.getOrDefault(o, defaultMessage);
    }

    public void register(Object o, String s) {
        messages.put(o, s);
    }
}
