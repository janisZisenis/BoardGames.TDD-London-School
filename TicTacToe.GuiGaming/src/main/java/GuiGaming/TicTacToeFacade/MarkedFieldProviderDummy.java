package GuiGaming.TicTacToeFacade;

import Domain.Data.Field.Field;
import Domain.Data.Mark;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.MarkedFieldProvider;

public class MarkedFieldProviderDummy implements MarkedFieldProvider {

    public Mark getMarkAt(Field f) {
        return null;
    }

    public boolean isMarked(Field f) {
        return false;
    }

}
