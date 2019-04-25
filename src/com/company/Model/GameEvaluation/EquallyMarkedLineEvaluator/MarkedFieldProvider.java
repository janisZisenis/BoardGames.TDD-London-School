package com.company.Model.GameEvaluation.EquallyMarkedLineEvaluator;

import com.company.Data.Mark;
import com.company.Data.Field.Field;

public interface MarkedFieldProvider {

    Mark getMarkAt(Field f);
    boolean isMarked(Field f);

    class FieldIsNotMarkedException extends RuntimeException {}
}
