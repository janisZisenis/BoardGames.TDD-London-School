package com.company.View;

import com.company.TicTacToe.Board.Mark;

public class MarkToXOMapper implements MarkToStringMapper {

    public String map(Mark m) {
        return m == Mark.John ? "X" : "O";
    }

}
