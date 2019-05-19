package Utilities.ObjectToStringMapper.Api;

import Utilities.ObjectToStringMapper.Api.ObjectToStringMapper;

import java.util.HashMap;

public class ObjectToStringMapperStub implements ObjectToStringMapper {

    private HashMap<Object, String> strings = new HashMap<>();

    public String map(Object o) {
        return strings.get(o);
    }

    public void setStringForObject(String s, Object o) {
        strings.put(o, s);
    }
}
