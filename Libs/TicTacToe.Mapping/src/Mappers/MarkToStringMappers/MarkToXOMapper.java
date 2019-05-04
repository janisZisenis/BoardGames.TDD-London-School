package Mappers.MarkToStringMappers;

import Domain.Board.Mark;
import Mappers.MarkToStringMapper;

public class MarkToXOMapper implements MarkToStringMapper {
    public String map(Mark m) {
        return m == Mark.John ? PlayerSymbols.john : PlayerSymbols.haley;
    }

}
