package Lib.Board;

import Lib.Data.Field.Field;
import Lib.Data.Mark;
import Lib.GameEvaluation.EquallyMarkedLineEvaluator.MarkedFieldProvider;
import Lib.GameOverRules.NumberOfMovesRule.MarkedFieldCountProvider;
import Lib.InputRules.FieldIsEmptyRule.FieldIsEmptyProvider;
import Lib.Players.MarkFieldService;

public interface Board extends ReadOnlyBoard, MarkFieldService, FieldIsEmptyProvider, MarkedFieldCountProvider, MarkedFieldProvider {

    boolean isEmpty(Field f);
    boolean isMarked(Field f);

    void mark(Field f, Mark m);
    Mark getMarkAt(Field f);
    int getMarkedFieldCount();

    class FieldIsNotMarked extends RuntimeException {}

}
