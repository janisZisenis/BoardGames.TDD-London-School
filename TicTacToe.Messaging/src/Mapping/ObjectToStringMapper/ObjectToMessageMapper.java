package Mapping.ObjectToStringMapper;

import java.util.HashMap;

public class ObjectToMessageMapper implements ObjectToStringMapper {

    private HashMap<Object, String> messages = new HashMap<>();

    public String map(Object o) {
        throwIfIsNotRegistered(o);

        return messages.get(o);
    }

    private void throwIfIsNotRegistered(Object o) {
        if(!messages.containsKey(o))
            throw new ObjectNotRegisteredForMapping();
    }

    public boolean isMappable(Object o) {
        return messages.containsKey(o);
    }

    public void register(Object o, String s) {
        messages.put(o, s);
    }
}
