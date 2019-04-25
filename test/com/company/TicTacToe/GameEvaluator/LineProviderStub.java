package com.company.TicTacToe.GameEvaluator;

import com.company.TicTacToe.Line;

public class LineProviderStub implements LineProvider {
    private Line[] lines = {};

    public void setProvidedLines(Line[] lines) {
        this.lines = lines;
    }

    public int getLineCount() {
        return lines.length;
    }

    public Line getLine(int index) {
        return lines[index];
    }
}
