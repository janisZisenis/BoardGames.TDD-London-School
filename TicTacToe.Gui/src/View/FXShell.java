package View;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class FXShell extends Pane {

    public FXShell(FXBoardView board, FXLoggerView logger) {
        GridPane grid = makeGrid();

        GridPane.setConstraints(board, 0, 0);
        GridPane.setConstraints(logger, 0, 1);

        grid.getChildren().addAll(board, logger);

        getChildren().add(grid);
    }

    private GridPane makeGrid() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(5);
        grid.setHgap(5);
        return grid;
    }

}
