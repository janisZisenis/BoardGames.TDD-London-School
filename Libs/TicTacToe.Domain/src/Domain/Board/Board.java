package Domain.Board;

import Data.Field.Field;
import Domain.Board.Api.FieldIsEmptyProvider;
import Domain.Board.Api.MarkFieldService;
import Domain.Board.Api.MarkedFieldCountProvider;
import Domain.Board.Api.MarkedFieldProvider;

public interface Board extends MarkFieldService, FieldIsEmptyProvider, MarkedFieldCountProvider, MarkedFieldProvider {

    boolean isEmpty(Field f);
    boolean isMarked(Field f);

    void mark(Field f, Mark m);
    Mark getMarkAt(Field f);
    int getMarkedFieldCount();

    class FieldIsNotMarked extends RuntimeException {}

}
