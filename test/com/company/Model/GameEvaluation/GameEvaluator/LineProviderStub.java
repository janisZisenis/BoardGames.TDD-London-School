package com.company.Model.GameEvaluation.GameEvaluator;

import com.company.Data.Line;

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
