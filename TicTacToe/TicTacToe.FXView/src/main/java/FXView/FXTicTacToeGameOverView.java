package FXView;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXTicTacToeGameOverView extends StackPane {

    private final static int winnerFontSize = 16;
    private final static Font winnerFont = new Font(winnerFontSize);

    private final static String cancelText = "Back to Main Menu";
    private final static String reconfigureText = "Reconfigure";
    private final static String restartText = "Restart";

    private static final String backgroundColor = "#c6ccd2";
    private static final int radius = 18;

    private final StackPane stack = new StackPane();
    private final Button cancel = new Button(cancelText);
    private final Button reconfigure = new Button(reconfigureText);
    private final Button restart = new Button(restartText);

    private final int width = 155;
    private final int height = 157;

//    private GameOverViewDelegate delegate;

//    public void setDelegate(GameOverViewDelegate delegate) {
//        this.delegate = delegate;
//    }

    public FXTicTacToeGameOverView() {
        initStack();
        initButtons();
        GridPane grid = fillGrid();

        stack.getChildren().add(grid);
        getChildren().add(stack);
    }

    private void initStack() {
        stack.setPadding(new Insets(10, 10, 10, 10));
        stack.setStyle("-fx-background-color: " + backgroundColor + " ;" +
                "-fx-background-radius: " + String.valueOf(radius) + ";"
        );

        stack.setMaxSize(width, height);
        stack.setMinSize(width, height);
        stack.setPrefSize(width, height);
    }

    private void initButtons() {
        cancel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        reconfigure.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        restart.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        cancel.setCancelButton(true);
        restart.setDefaultButton(true);

        cancel.setOnAction(e -> onCancelClicked());
        reconfigure.setOnAction(e -> onReconfigureClicked());
        restart.setOnAction(e -> onRestartClicked());
    }

    private GridPane fillGrid() {
        Label winner = new Label("Draw!");
        winner.setMaxWidth(Double.MAX_VALUE);

        winner.setFont(winnerFont);
        winner.setAlignment(Pos.BASELINE_CENTER);

        GridPane grid = new GridPane();
        grid.setVgap(5);
        grid.add(winner, 0, 0);
        grid.add(new Text(), 0, 1);
        grid.add(cancel, 0, 2);
        grid.add(reconfigure, 0, 3);
        grid.add(restart, 0, 4);
        return grid;
    }


    private void onCancelClicked() {
//        if(delegate != null)
//            delegate.onCancelClicked();
    }

    private void onReconfigureClicked() {
//        if(delegate != null)
//            delegate.onReconfigureClicked();
    }

    private void onRestartClicked() {
//        if(delegate != null)
//            delegate.onRestartClicked();
    }

}
