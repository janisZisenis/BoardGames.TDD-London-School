package FXView;

import Presentation.ConfigureViewPresenter.Api.ConfigureViewDelegate;
import Presentation.ConfigureViewPresenter.ConfigureView;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class FXTicTacToeConfigureView extends Pane implements ConfigureView {

    private static final String configureFirst = "Configure first Player: X";
    private static final String configureSecond = "Configure second Player: O";
    private static final String startText = "Start Game";
    private static final String cancelText = "Back to Main Menu";

    private static final String background = "#c6ccd2";

    private final int width = 380;
    private final int height = 205;

    private final Text firstConfig = new Text(configureFirst);
    private final Text secondConfig = new Text(configureSecond);

    private final StackPane stack = new StackPane();
    private final GridPane grid = new GridPane();

    private final Button start = new Button(startText);
    private final Button cancel = new Button(cancelText);

    private ConfigureViewDelegate delegate;

    public void setDelegate(ConfigureViewDelegate delegate) {
        this.delegate = delegate;
    }

    public FXTicTacToeConfigureView(Pane firstPlayer, Pane secondPlayer) {
        init();
        initButtons();
        fillGrid(firstPlayer, secondPlayer);

        stack.getChildren().add(grid);
        getChildren().add(stack);
    }

    private void fillGrid(Pane firstPlayer, Pane secondPlayer) {
        grid.setHgap(5);

        grid.add(firstConfig, 0, 0);
        grid.add(secondConfig, 2, 0);
        grid.add(new Text(), 0, 1, 3, 1);

        grid.add(firstPlayer, 0, 2);
        grid.add(secondPlayer, 2, 2);

        grid.add(new Text(), 0, 3, 3, 1);
        grid.add(start, 2, 4);
        grid.add(cancel, 0, 4);

        Separator line = new Separator();
        line.setOrientation(Orientation.VERTICAL);
        grid.add(line, 1, 0, 1, 3);
    }

    private void init() {
        setStyle("-fx-background-color: " + background + " ;" +
                "-fx-background-radius: 18;"
        );
        setMinSize(width, height);
        setMaxSize(width, height);
        setPrefSize(width, height);
        stack.setPadding(new Insets(10, 10, 10, 10));
    }

    private void initButtons() {
        start.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        start.setDefaultButton(true);
        start.setOnAction(e -> onStartClicked());
        cancel.setCancelButton(true);
        cancel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        cancel.setOnAction(e -> onCancelClicked());
    }

    private void onStartClicked() {
        if(delegate != null)
            delegate.onStartClicked();
    }

    private void onCancelClicked() {
        if(delegate != null)
            delegate.onCancelClicked();
    }

    public void enableStartButton() {
        start.setDisable(false);
    }

    public void disableStartButton() {
        start.setDisable(true);
    }
}
