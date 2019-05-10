package GuiGaming.TicTacToePresenter;

import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.Data.Mark;

public class BoardViewSpy implements BoardView {

    private boolean didSet = false;
    private Field setField;
    private Mark setMark;
    private boolean didClear = false;
    private Field clearedField;
    private boolean didHighlight = false;
    private Line highlighted;

    public Field getSetField() {
        return setField;
    }

    public boolean hasSetField() {
        return didSet;
    }
    public Mark getSetMark() {
        return setMark;
    }
    public void setField(Field field, Mark mark) {
        didSet = true;
        setField = field;
        setMark = mark;
    }

    public boolean hasCleared() {
        return didClear;
    }
    public Field getClearedField() {
        return clearedField;
    }
    public void clear(Field field) {
        didClear = false;
        clearedField = field;
    }

    public Line getHighlighted() {
        return highlighted;
    }
    public void highlightLine(Line line) {
        didHighlight = true;
        highlighted = line;
    }

    public boolean hasHighlighted() {
        return didHighlight;
    }
}
