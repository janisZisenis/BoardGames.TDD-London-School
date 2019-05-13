package View;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class FXStartView extends StackPane {

    private String startTitle = "Start";
    private String cancelTitle = "Cancel";
    private String startText = "Press the start button to start the game!";

    private StackPane root = new StackPane();
    private StackPane stack = new StackPane();
    private Button startBtn;

    private FXTicTacToeView delegate;

    public FXStartView() {
        root.setStyle("-fx-background-color: transparent;");
        initRoot();
        initStackPane();
        initStartButton();

        initGrid();
    }

    private void onStartClicked() {
        if(delegate != null)
            delegate.onStartClicked();
    }

    private void initGrid() {
        GridPane grid = new GridPane();
        Label startLabel = new Label(startText);
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
        grid.add(startBtn, 2, 4);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(48);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(4);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(48);
        grid.getColumnConstraints().addAll(col1, col2, col3);

        stack.getChildren().add(grid);
    }

    private void initStartButton() {
        startBtn = new Button(startTitle);
        startBtn.setDefaultButton(true);
        startBtn.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        startBtn.setOnMouseClicked(e -> onStartClicked());
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
