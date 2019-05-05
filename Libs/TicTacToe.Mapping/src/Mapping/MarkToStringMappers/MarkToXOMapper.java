package Mapping.MarkToStringMappers;

import Domain.Data.Mark;
import Mapping.MarkToStringMapper;
import Messages.PlayerSymbols;

public class MarkToXOMapper implements MarkToStringMapper {
    public String map(Mark m) {
        return m == Mark.John ? PlayerSymbols.john : PlayerSymbols.haley;
    }

}
