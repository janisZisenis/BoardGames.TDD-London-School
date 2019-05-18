package FXView;

import Domain.Data.BoardBoundaries;
import Presentation.ConfigureViewPresenter.Api.ConfigureViewDelegate;
import Presentation.ConfigureViewPresenter.ConfigureView;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class FXTicTacToeConfigureView extends FXGameView implements ConfigureView {

    private static final int boardSideLength = BoardBoundaries.rowColumnCount;
    private static final int lineLength = BoardBoundaries.winningLineLength;
    private static final String comingSoonText = ComingSoonConstants.text;
    private static final Color comingSoonColor = ComingSoonConstants.color;
    private static final Font comingSoonFont = ComingSoonConstants.font;

    private static final String background = "#c6ccd2";
    private static final int headerFontSize = 14;
    private static final Font headerFont = new Font(headerFontSize);

    private static final String configureBoardText = "Configure Your Board!";
    private static final String sideLengthText = "Board Side Length:";
    private static final String lineLengthText = "Winning Line Length:";
    private static final String configurePlayersText = "Configure Your Players!";
    private static final String configureFirstText = "First Player: X";
    private static final String configureSecondText = "Second Player: O";
    private static final String startText = "Start Game";
    private static final String cancelText = "Back to Main Menu";

    private final int width = 380;
    private final int height = 205;

    private final Button cancel = new Button(cancelText);
    private final Button start = new Button(startText);

    private ConfigureViewDelegate delegate;

    public void setDelegate(ConfigureViewDelegate delegate) {
        this.delegate = delegate;
    }

    public FXTicTacToeConfigureView(Pane firstPlayer, Pane secondPlayer) {
        init();
        initButtons();

        Pane boardSection = makeBoardSection();
        Pane playersSection = makePlayersSection(firstPlayer, secondPlayer);
        Pane buttonSection = makeButtonSection();

        GridPane grid = makeGrid(boardSection, playersSection, buttonSection);
        grid.setStyle("-fx-background-color: black ;");

        grid.setMinSize(width, height);
        grid.setMaxSize(width, height);
        grid.setPrefSize(width, height);

        getChildren().add(grid);
    }

    private void init() {
        registerShowListener();
    }

    private GridPane makeGrid(Pane boardSection, Pane playersSection, Pane buttonSection) {
        GridPane grid = new GridPane();
        grid.add(boardSection, 0, 0);
        grid.add(new Text(), 0, 1);
        grid.add(playersSection, 0, 2);
        grid.add(new Text(), 0, 3);
        grid.add(buttonSection, 0, 4);
        return grid;
    }

    private Pane makeBoardSection() {
        GridPane grid = makeSectionGrid();

        Text header = new Text(configureBoardText);
        header.setFont(headerFont);
        grid.add(header, 0, 0);
        grid.add(new Text(), 0, 1);

        GridPane sideLengthGrid = makeBoardFieldGrid(sideLengthText, boardSideLength);
        GridPane lineLengthGrid = makeBoardFieldGrid(lineLengthText, lineLength);

        grid.add(sideLengthGrid, 0, 2);
        grid.add(lineLengthGrid, 0, 3);

        return grid;
    }

    private GridPane makeBoardFieldGrid(String s, int value) {
        GridPane grid = new GridPane();
        grid.setHgap(5);

        Label label = new Label(s);
        label.setDisable(true);
        label.setMaxWidth(Double.MAX_VALUE);
        TextField field = new TextField(String.valueOf(value));
        field.setMaxWidth(30);
        field.setAlignment(Pos.BASELINE_RIGHT);
        field.setDisable(true);

        ColumnConstraints col1 = new ColumnConstraints();
        int colWidth = 135;
        col1.setMinWidth(colWidth);
        col1.setMaxWidth(colWidth);
        grid.getColumnConstraints().add(col1);

        grid.add(label, 0, 0);
        grid.add(field, 1, 0);
        grid.add(makeComingSoon(), 2, 0);

        return grid;
    }

    private Text makeComingSoon() {
        Text text = new Text(comingSoonText);
        text.setFont(comingSoonFont);
        text.setFill(comingSoonColor);

        return text;
    }

    private Pane makePlayersSection(Pane firstPlayer, Pane secondPlayer) {
        GridPane grid = makeSectionGrid();

        Text header = new Text(configurePlayersText);
        header.setFont(headerFont);

        grid.add(header, 0, 0, 2, 1);
        grid.add(new Text(), 0, 1, 2, 1);
        grid.add(new Text(configureFirstText), 0, 2);
        grid.add(new Text(configureSecondText), 2, 2);
        grid.add(new Text(), 0, 3, 3, 1);

        grid.add(firstPlayer, 0, 4);
        grid.add(secondPlayer, 2, 4);

        Separator line = new Separator();
        line.setOrientation(Orientation.VERTICAL);
        grid.add(line, 1, 2, 1, 4);

        return grid;
    }

    private Pane makeButtonSection() {
        GridPane grid = makeSectionGrid();

        grid.add(cancel, 0, 0);
        grid.add(start, 1, 0);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(50);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(50);

        grid.getColumnConstraints().addAll(col1, col2);

        return grid;
    }

    private GridPane makeSectionGrid() {
        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: " + background + " ;" +
                "-fx-background-radius: 18;"
        );
        grid.setHgap(5);
        grid.setPadding(new Insets(10, 10, 10, 10));
        return grid;
    }

    private void registerShowListener() {
        sceneProperty().addListener((obs, oldScene, newScene) -> {
            if(newScene != null)
                onViewDidShow();
        });
    }

    private void onViewDidShow() {
        if (delegate != null)
            delegate.onViewDidShow();
    }

    private void initButtons() {
        cancel.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        start.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

        cancel.setCancelButton(true);
        start.setDefaultButton(true);

        cancel.setOnAction(e -> onCancelClicked());
        start.setOnAction(e -> onStartClicked());

        start.setDisable(true);
        cancel.setDisable(false);
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
