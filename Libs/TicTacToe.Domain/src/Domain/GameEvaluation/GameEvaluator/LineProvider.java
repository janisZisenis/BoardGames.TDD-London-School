package Domain.GameEvaluation.GameEvaluator;

import Domain.Data.Line.Line;

public interface LineProvider {
    int getLineCount();
    Line getLine(int index);

    class LineIndexNotAvailable extends RuntimeException {}
}
