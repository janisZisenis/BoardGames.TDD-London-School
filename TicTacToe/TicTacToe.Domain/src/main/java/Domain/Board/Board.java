package Domain.Board;

import Domain.Data.Field.Field;
import Domain.Data.Mark;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.MarkedFieldProvider;
import Domain.NumberOfMovesRule.MarkedFieldCountProvider;
import Domain.TicTacToePlayer.MarkFieldService;
import Domain.FieldIsEmptyValidator.FieldIsEmptyProvider;
import Gaming.RestartTransaction.ClearGameStateService;

public interface Board extends MarkFieldService, FieldIsEmptyProvider, MarkedFieldCountProvider, MarkedFieldProvider, ClearGameStateService {

    boolean isEmpty(Field f);
    boolean isMarked(Field f);

    void mark(Field f, Mark m);
    Mark getMarkAt(Field f);
    int getMarkedFieldCount();

    void clear();

}
