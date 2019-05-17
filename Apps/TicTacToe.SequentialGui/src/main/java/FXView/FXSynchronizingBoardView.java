package FXView;

import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.Data.Mark;
import Presentation.BoardViewPresenter.BoardView;
import Presentation.WinningLinePresenter.WinningLineView;
import javafx.application.Platform;
import javafx.scene.layout.Pane;

public class FXSynchronizingBoardView extends Pane implements BoardView, WinningLineView {

    private final FXBoardView view;

    public FXSynchronizingBoardView(int rowColumnCount, int sideLength) {
        view = new FXBoardView(rowColumnCount);
        view.setSideLength(sideLength);
        getChildren().add(view);
    }

    public void setField(Field field, Mark m) {
        Platform.runLater(() -> {
            view.setField(field, m);
        });
    }

    public void clearField(Field field) {
        Platform.runLater(() -> {
            view.clearField(field);
        });
    }

    @Override
    public void highlightLine(Line line) {
        Platform.runLater(() -> {
            view.highlightLine(line);
        });
    }
}
