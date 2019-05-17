package BoardGames.View;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class FXTicTacToeConfigView extends FXGameView {

    private static final String configureFirst = "Configure first Player: X";
    private static final String configureSecond = "Configure second Player: O";
    private static final String startText = "Start Game";
    private static final String cancelText = "Back to Main Menu";

    private static final String firstPlayer = "Player 1";
    private static final String secondPlayer = "Player 2";

    private static final String background = "#b3b2b2";

    private final int width = 380;
    private final int height = 205;

    private final Text firstConfig = new Text(configureFirst);
    private final Text secondConfig = new Text(configureSecond);

    private final FXTicTacToeChoosePlayerView first = new FXTicTacToeChoosePlayerView(firstPlayer);
    private final FXTicTacToeChoosePlayerView second = new FXTicTacToeChoosePlayerView(secondPlayer);

    private final StackPane stack = new StackPane();
    private final GridPane grid = new GridPane();

    private final Button start = new Button(startText);
    private final Button cancel = new Button(cancelText);

    public FXTicTacToeConfigView() {
        setStyle("-fx-background-color: " + background + " ;" +
                "-fx-background-radius: 18;"
        );
        setMinSize(width, height);
        setMaxSize(width, height);
        setPrefSize(width, height);

        start.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        start.setDefaultButton(true);
        cancel.setCancelButton(true);
        cancel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        stack.setPadding(new Insets(10, 10, 10, 10));

        grid.setHgap(5);

        grid.add(firstConfig, 0, 0);
        grid.add(secondConfig, 2, 0);
        grid.add(new Text(), 0, 1, 3, 1);

        grid.add(first, 0, 2);
        grid.add(second, 2, 2);

        grid.add(new Text(), 0, 3, 3, 1);
        grid.add(start, 2, 4);
        grid.add(cancel, 0, 4);

        Separator line = new Separator();
        line.setOrientation(Orientation.VERTICAL);
        grid.add(line, 1, 0, 1, 3);

        stack.getChildren().add(grid);
        getChildren().add(stack);
    }

    public void setSideLength(double sideLength) {

    }

}
