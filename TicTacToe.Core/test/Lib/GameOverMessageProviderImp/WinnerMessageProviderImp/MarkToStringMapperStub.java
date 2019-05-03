package Lib.GameOverMessageProviderImp.WinnerMessageProviderImp;

import Lib.Data.Mark;

import java.util.HashMap;

public class MarkToStringMapperStub implements MarkToStringMapper {

    HashMap<Mark, String> map = new HashMap<>();

    public String map(Mark m) {
        return map.get(m);
    }

    public void setMappedStringForMark(Mark m, String john) {
        map.put(m, john);
    }
}
