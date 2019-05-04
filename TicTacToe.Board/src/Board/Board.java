package Board;

import Api.ReadOnlyBoard;
import Data.Field.Field;
import Api.MarkedFieldProvider;
import Api.MarkedFieldCountProvider;
import Api.FieldIsEmptyProvider;
import Api.MarkFieldService;

public interface Board extends ReadOnlyBoard, MarkFieldService, FieldIsEmptyProvider, MarkedFieldCountProvider, MarkedFieldProvider {

    boolean isEmpty(Field f);
    boolean isMarked(Field f);

    void mark(Field f, Mark m);
    Mark getMarkAt(Field f);
    int getMarkedFieldCount();

    class FieldIsNotMarked extends RuntimeException {}

}
