package Domain.GameEvaluation.EquallyMarkedLineEvaluator;

import Domain.Data.Field.Field;
import Domain.Data.Mark;

public class MarkedFieldProviderDummy implements MarkedFieldProvider {

    public Mark getMarkAt(Field f) {
        return null;
    }

    public boolean isMarked(Field f) {
        return false;
    }

}
