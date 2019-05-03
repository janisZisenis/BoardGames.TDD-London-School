package Messaging.Mapping.MarkToStringMappers;

import Lib.Data.Mark;
import Messaging.Mapping.MarkToStringMapper;

public class MarkToXOMapper implements MarkToStringMapper {
    public String map(Mark m) {
        return m == Mark.John ? PlayerSymbols.john : PlayerSymbols.haley;
    }

}
