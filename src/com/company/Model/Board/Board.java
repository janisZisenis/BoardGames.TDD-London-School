package com.company.Model.Board;

import com.company.Data.Mark;
import com.company.Model.GameOverRules.NumberOfMovesRule.MarkedFieldCountProvider;
import com.company.Data.Field.Field;
import com.company.Model.InputRules.FieldIsEmptyRule.FieldIsEmptyProvider;
import com.company.Model.GameEvaluation.EquallyMarkedLineEvaluator.MarkedFieldProvider;
import com.company.Model.Players.MarkFieldService;

public interface Board extends MarkFieldService, FieldIsEmptyProvider, MarkedFieldCountProvider, MarkedFieldProvider {

    boolean isEmpty(Field f);
    boolean isMarked(Field f);

    void mark(Field f, Mark m);
    Mark getMarkAt(Field f);
    int getMarkedFieldCount();

    class FieldIsNotMarked extends RuntimeException {}

}
