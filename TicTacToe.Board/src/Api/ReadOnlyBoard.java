package Api;

import Board.Mark;
import Data.Field.Field;

public interface ReadOnlyBoard {

    boolean isMarked(Field f);
    Mark getMarkAt(Field f);

}
