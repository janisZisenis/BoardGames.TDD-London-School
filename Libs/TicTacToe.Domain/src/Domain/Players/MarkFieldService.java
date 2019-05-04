package Domain.Players;

import Domain.Data.Field.Field;
import Domain.Board.Mark;

public interface MarkFieldService {
    void mark(Field f, Mark m);
}
