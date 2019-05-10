package App;

import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.Data.Mark;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.MarkedFieldProvider;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProvider;
import InputGeneration.Input.Input;
import InputGeneration.InputProcessor;

public class BoardViewInteractor {

    private final MarkedFieldProvider fieldProvider;
    private final WinningLineProvider lineProvider;
    private final InputProcessor processor;

    public BoardViewInteractor(InputProcessor processor, MarkedFieldProvider fieldProvider, WinningLineProvider lineProvider) {
        this.fieldProvider = fieldProvider;
        this.lineProvider = lineProvider;
        this.processor = processor;
    }

    public void process(Input input) {
        processor.process(input);
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
