package Lib.Presentation.MarkToStringMapper;


import Lib.Data.Mark;

public class MarkToXOMapper implements MarkToStringMapper {

    public String map(Mark m) {
        return m == Mark.John ? "X" : "O";
    }

}
