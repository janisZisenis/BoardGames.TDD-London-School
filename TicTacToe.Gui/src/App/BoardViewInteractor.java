package App;

import Api.MarkedFieldProvider;
import Board.Mark;
import Data.Field.Field;
import Data.Line.Line;
import Bussiness.BoardRenderer.WinningLineProvider;
import Bussiness.Input.Input;
import GuiGaming.ValidatingInputProcessor.InputProcessor;

public class BoardViewInteractor {

    private final MarkedFieldProvider fieldProvider;
    private final WinningLineProvider lineProvider;
    private final InputProcessor processor;

    public BoardViewInteractor(MarkedFieldProvider fieldProvider, WinningLineProvider lineProvider, InputProcessor processor) {
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
