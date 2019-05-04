package Board;

import Data.Field.Field;
import Data.Mark;

public interface ReadOnlyBoard {

    boolean isMarked(Field f);
    Mark getMarkAt(Field f);

}
