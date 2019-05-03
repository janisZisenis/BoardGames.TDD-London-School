package Messaging.Turn.TurnMessengerImp;

import Messaging.Mapping.ObjectToStringMapper.ObjectToStringMapper;

import java.util.HashMap;

public class ObjectToStringMapperFake implements ObjectToStringMapper {

    private HashMap<Object, String> strings = new HashMap();

    public String map(Object o) {
        throwIfIsNotMappable(o);

        return strings.get(o);
    }

    private void throwIfIsNotMappable(Object o) {
        if(!isMappable(o))
            throw new ObjectNotMappableToString();
    }

    public boolean isMappable(Object o) {
        return strings.containsKey(o);
    }

    public void register(Object o, String s) {
        strings.put(o, s);
    }
}
