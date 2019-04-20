package com.company.TicTacToe.WinningProvider;

import com.company.TicTacToe.Line;

public interface LineProvider {
    int getLineCount();
    Line getLine(int index);

    public class LineIndexNotAvailable extends RuntimeException {}
}
