package GuiGaming.TicTacToePresenter;

import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.Data.Mark;

public interface BoardView {
    void setField(Field field, Mark mark);
    void clear(Field field);
    void highLight(Line line);
}
