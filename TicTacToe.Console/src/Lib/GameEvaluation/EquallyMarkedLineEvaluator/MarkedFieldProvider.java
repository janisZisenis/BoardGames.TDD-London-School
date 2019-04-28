package Lib.GameEvaluation.EquallyMarkedLineEvaluator;

import Lib.Data.Field.Field;
import Lib.Data.Mark;

public interface MarkedFieldProvider {

    Mark getMarkAt(Field f);
    boolean isMarked(Field f);

    class FieldIsNotMarkedException extends RuntimeException {}
}
