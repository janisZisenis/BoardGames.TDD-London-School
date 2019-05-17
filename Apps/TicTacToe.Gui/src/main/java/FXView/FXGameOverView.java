package FXView;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class FXGameOverView extends StackPane {

    private String restartTitle = "Restart";
    private String cancelTitle = "Cancel";
    private String restartText = "The game is over. Would you start again?";

    private StackPane root = new StackPane();
    private StackPane stack = new StackPane();
    private Button restartBtn;

    private FXTicTacToeView delegate;

    public FXGameOverView() {
        root.setStyle("-fx-background-color: transparent;");
        initRoot();
        initStackPane();
        initRestartButton();

        initGrid();
    }

    private void onRestartClicked() {
        if(delegate != null)
            delegate.onRestartClicked();
    }

    private void initGrid() {
        GridPane grid = new GridPane();
        Label startLabel = new Label(restartText);
        Button cancelButton = new Button(cancelTitle);
        cancelButton.setCancelButton(true);
        cancelButton.setDisable(true);
        cancelButton.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        grid.add(new Label(), 0, 0, 3, 1);
        grid.add(startLabel, 0, 1, 3, 1);
        grid.add(new Label(), 0, 2, 3, 1);
        grid.add(new Label(), 0, 3, 3, 1);
        grid.add(cancelButton, 0, 4);
        grid.add(new Label(), 1, 4);
        grid.add(restartBtn, 2, 4);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(48);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(4);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(48);
        grid.getColumnConstraints().addAll(col1, col2, col3);

        stack.getChildren().add(grid);
    }

    private void initRestartButton() {
        restartBtn = new Button(restartTitle);
        restartBtn.setDefaultButton(true);
        restartBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        restartBtn.setOnMouseClicked(e -> onRestartClicked());
    }

    private void initStackPane() {
        stack.setStyle("-fx-background-color: lightgray;");
        stack.setMaxSize(270, 100);
        stack.setMinSize(270, 100);
        getChildren().add(stack);
    }

    private void initRoot() {
        root.setMaxSize(300, 150);
        root.setMinSize(300, 150);
        root.setStyle("-fx-background-color: lightgray;");
        getChildren().add(root);
    }

    public void setDelegate(FXTicTacToeView delegate) {
        this.delegate = delegate;
    }

}
