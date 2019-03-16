package com.company.TicTacToe.GameOver.GameHasWinnerReferee;

import com.company.TicTacToe.Line;

public class LineProviderStub implements LineProvider {
    private Line[] lines = {};

    public void setLines(Line[] lines) {
        this.lines = lines;
    }

    public int getLineCount() {
        return lines.length;
    }

    public Line getLine(int index) {
        return lines[index];
    }
}
