package Lib.Model.Board;

import Lib.Data.Field.Field;
import Lib.Data.Mark;

public interface ReadOnlyBoard {

    boolean isMarked(Field f);
    Mark getMarkAt(Field f);

}
