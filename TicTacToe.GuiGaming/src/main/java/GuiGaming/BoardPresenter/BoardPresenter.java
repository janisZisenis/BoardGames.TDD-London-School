package GuiGaming.BoardPresenter;

import Domain.Data.Field.Field;
import Domain.Data.Mark;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.MarkedFieldProvider;

public class BoardPresenter {

    private final BoardView view;
    private final MarkedFieldProvider provider;

    public BoardPresenter(MarkedFieldProvider provider, BoardView view) {
        this.provider = provider;
        this.view = view;
    }

    public void onFieldUpdated(Field field) {
        if(isMarked(field))
            setField(field);
        else
            clearField(field);
    }

    private void clearField(Field field) {
        view.clearField(field);
    }

    private void setField(Field field) {
        Mark m = provider.getMarkAt(field);
        view.setField(field, m);
    }

    private boolean isMarked(Field field) {
        return provider.isMarked(field);
    }

}
