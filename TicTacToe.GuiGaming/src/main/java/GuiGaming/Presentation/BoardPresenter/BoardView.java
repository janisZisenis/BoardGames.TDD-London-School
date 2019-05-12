package GuiGaming.Presentation.BoardPresenter;

import Domain.Data.Field.Field;
import Domain.Data.Mark;

public interface BoardView {
    void setField(Field field, Mark m);
    void clearField(Field field);
}
