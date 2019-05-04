package Domain.Board;

import Data.Field.Field;
import Domain.InputRules.FieldIsEmptyRule.FieldIsEmptyProvider;
import Domain.Players.MarkFieldService;
import Domain.NumberOfMovesRule.MarkedFieldCountProvider;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.MarkedFieldProvider;

public interface Board extends MarkFieldService, FieldIsEmptyProvider, MarkedFieldCountProvider, MarkedFieldProvider {

    boolean isEmpty(Field f);
    boolean isMarked(Field f);

    void mark(Field f, Mark m);
    Mark getMarkAt(Field f);
    int getMarkedFieldCount();

    class FieldIsNotMarked extends RuntimeException {}

}
