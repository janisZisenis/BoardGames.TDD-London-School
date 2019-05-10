package GuiGaming.TicTacToePresenter;

import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.Data.Mark;

public interface BoardView {
    void setField(Field field, Mark john);
    void clear(Field field);
    void highlightLine(Line line);
}
