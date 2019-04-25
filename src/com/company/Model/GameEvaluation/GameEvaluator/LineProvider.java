package com.company.Model.GameEvaluation.GameEvaluator;

import com.company.Data.Line;

public interface LineProvider {
    int getLineCount();
    Line getLine(int index);

    class LineIndexNotAvailable extends RuntimeException {}
}
