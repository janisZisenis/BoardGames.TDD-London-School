package Board;

import Api.FieldIsEmptyProvider;
import Api.MarkFieldService;
import Api.MarkedFieldCountProvider;
import Api.MarkedFieldProvider;
import Data.Field.Field;

public interface Board extends MarkFieldService, FieldIsEmptyProvider, MarkedFieldCountProvider, MarkedFieldProvider {

    boolean isEmpty(Field f);
    boolean isMarked(Field f);

    void mark(Field f, Mark m);
    Mark getMarkAt(Field f);
    int getMarkedFieldCount();

    class FieldIsNotMarked extends RuntimeException {}

}
