package com.company.Presentation.MarkToStringMapper;

import com.company.Data.Mark;

public class MarkToXOMapper implements MarkToStringMapper {

    public String map(Mark m) {
        return m == Mark.John ? "X" : "O";
    }

}
