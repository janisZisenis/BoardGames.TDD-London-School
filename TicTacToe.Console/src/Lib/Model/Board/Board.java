package Lib.Model.Board;

import Lib.Data.Field.Field;
import Lib.Data.Mark;
import Lib.Model.GameEvaluation.EquallyMarkedLineEvaluator.MarkedFieldProvider;
import Lib.Model.GameOverRules.NumberOfMovesRule.MarkedFieldCountProvider;
import Lib.Model.InputRules.FieldIsEmptyRule.FieldIsEmptyProvider;
import Lib.Model.Players.MarkFieldService;

public interface Board extends MarkFieldService, FieldIsEmptyProvider, MarkedFieldCountProvider, MarkedFieldProvider {

    boolean isEmpty(Field f);
    boolean isMarked(Field f);

    void mark(Field f, Mark m);
    Mark getMarkAt(Field f);
    int getMarkedFieldCount();

    class FieldIsNotMarked extends RuntimeException {}

}
