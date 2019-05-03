package Messaging.Mapping.MarkToStringMappers;

import Messaging.Game.WinnerMessageProviderImp.MarkToStringMapper;
import Lib.Data.Mark;

public class MarkToMessageMapper implements MarkToStringMapper {
    private String johnMessage;
    private String haleyMessage;

    public MarkToMessageMapper(String johnMessage, String haleyMessage) {
        this.johnMessage = johnMessage;
        this.haleyMessage = haleyMessage;
    }

    public String map(Mark m) {
        return m == Mark.John ? johnMessage : haleyMessage;
    }
}
