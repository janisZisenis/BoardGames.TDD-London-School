package Lib.MarkToStringMappers;

import Lib.Data.Mark;

public class MarkToMessageMapper {
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
