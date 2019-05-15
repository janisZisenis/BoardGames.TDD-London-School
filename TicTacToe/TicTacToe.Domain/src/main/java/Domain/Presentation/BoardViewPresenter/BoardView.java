package Domain.Presentation.BoardViewPresenter;

import Domain.Data.Field.Field;
import Domain.Data.Mark;

public interface BoardView {
    void setField(Field field, Mark m);
    void clearField(Field field);
}
