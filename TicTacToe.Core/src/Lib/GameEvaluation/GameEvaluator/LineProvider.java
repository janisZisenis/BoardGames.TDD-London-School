package Lib.GameEvaluation.GameEvaluator;

import Lib.Data.Line;

public interface LineProvider {
    int getLineCount();
    Line getLine(int index);

    class LineIndexNotAvailable extends RuntimeException {}
}
