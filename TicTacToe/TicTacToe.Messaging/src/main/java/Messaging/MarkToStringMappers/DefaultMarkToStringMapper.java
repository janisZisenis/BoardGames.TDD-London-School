package Messaging.MarkToStringMappers;

import Domain.Data.Mark;
import Messaging.WinnerMessageProviderImp.MarkToStringMapper;

public class DefaultMarkToStringMapper implements MarkToStringMapper {
    private String johnMessage;
    private String haleyMessage;

    public DefaultMarkToStringMapper(String johnMessage, String haleyMessage) {
        this.johnMessage = johnMessage;
        this.haleyMessage = haleyMessage;
    }

    public String map(Mark m) {
        return m == Mark.John ? johnMessage : haleyMessage;
    }
}
