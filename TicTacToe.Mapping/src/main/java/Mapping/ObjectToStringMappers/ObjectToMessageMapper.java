//package Mapping.ObjectToStringMappers;
//
//import Mapping.ObjectToStringMapper;
//
//import java.util.HashMap;
//
//public class ObjectToMessageMapper implements ObjectToStringMapper {
//
//    private HashMap<Object, String> messages = new HashMap<>();
//
//    public String map(Object o) {
//        return messages.get(o);
//    }
//
//
//    public boolean isMappable(Object o) {
//        return messages.containsKey(o);
//    }
//
//    public void register(Object o, String s) {
//        messages.put(o, s);
//    }
//}
