package Messaging.MarkToStringMappers;

import Domain.Data.Mark;
import Messages.PlayerSymbols;
import Messaging.WinnerMessageProviderImp.MarkToStringMapper;

public class MarkToXOMapper implements MarkToStringMapper {
    public String map(Mark m) {
        return m == Mark.John ? PlayerSymbols.john : PlayerSymbols.haley;
    }

}
