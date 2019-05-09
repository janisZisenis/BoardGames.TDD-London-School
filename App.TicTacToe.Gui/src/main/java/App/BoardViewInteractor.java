package App;

import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.Data.Mark;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.MarkedFieldProvider;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import InputGeneration.Input.Input;

public class BoardViewInteractor {

    private final MarkedFieldProvider fieldProvider;
    private final WinningLineProvider lineProvider;

    public BoardViewInteractor(MarkedFieldProvider fieldProvider, WinningLineProvider lineProvider) {
        this.fieldProvider = fieldProvider;
        this.lineProvider = lineProvider;
    }

    public void process(Input input) {

    }

    public boolean hasWinningLine() {
        return lineProvider.hasWinningLine();
    }

    public Line getWinningLine() {
        return lineProvider.getWinningLine();
    }

    public boolean isMarked(Field f) {
        return fieldProvider.isMarked(f);
    }

    public Mark getMarkAt(Field f) {
        return fieldProvider.getMarkAt(f);
    }

}
