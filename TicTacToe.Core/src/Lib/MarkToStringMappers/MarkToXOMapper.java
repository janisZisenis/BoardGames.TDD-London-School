package Lib.MarkToStringMappers;

import Lib.Data.Mark;
import Lib.GameOverMessageProviderImp.WinnerMessageProviderImp.MarkToStringMapper;

public class MarkToXOMapper implements MarkToStringMapper {
    public String map(Mark m) {
        return m == Mark.John ? FieldSymbols.john : FieldSymbols.haley;
    }

}
