package Mapping.MarkToStringMappers;

import Game.WinnerMessageProviderImp.MarkToStringMapper;
import Lib.Data.Mark;

public class MarkToXOMapper implements MarkToStringMapper {
    public String map(Mark m) {
        return m == Mark.John ? FieldSymbols.john : FieldSymbols.haley;
    }

}
