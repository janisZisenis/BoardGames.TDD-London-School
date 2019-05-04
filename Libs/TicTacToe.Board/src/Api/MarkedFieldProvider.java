package Api;

import Data.Field.Field;
import Board.Mark;

public interface MarkedFieldProvider {

    Mark getMarkAt(Field f);
    boolean isMarked(Field f);

    class FieldIsNotMarked extends RuntimeException {}
}
