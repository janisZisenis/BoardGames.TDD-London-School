package BoardGames.View;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

public class FXBoardView extends FXGameView {

    private final int rowColumnCount;

    private final StackPane stack = new StackPane();
    private final GridPane board = new GridPane();
    private final int padding = 5;
    private final String borderColor = "#4a4549";
    private final String tileColor = "#f0ffff";

    public FXBoardView(int rowColumnCount) {
        this.rowColumnCount = rowColumnCount;

        init();
        registerShowListener();
    }

    private void init() {
        applyBoardStyle();
        stack.getChildren().add(board);
        getChildren().add(stack);
    }

    private void applyBoardStyle() {
        board.setStyle(
                "-fx-background-color: " + borderColor + ";"+
                        "-fx-padding: "+ padding +" ;"
        );
    }

    private void registerShowListener() {
        sceneProperty().addListener((obs, oldScene, newScene) -> {
            if(newScene != null)
                onViewDidShow();
        });
    }

    private void onViewDidShow() {
        initTiles();
    }



    private void initTiles() {
        double tileLength = (super.sideLength - 2 * padding) / rowColumnCount;
        for(int row = 0; row < rowColumnCount; row++) {
            for(int col = 0; col < rowColumnCount; col++ ) {
                FXTile t = makeTile(tileLength);
                board.add(t, col, row);
            }
        }
    }

    private FXTile makeTile(double sideLength) {
        FXTile t = new FXTile(sideLength);
        t.setStyle(
                "-fx-background-color: " + borderColor + ", " + tileColor + ";"+
                        "-fx-background-insets: 0, 0 1 1 0 ;"
        );
        return t;
    }

    private class FXTile extends StackPane {

        private final double fontRatio = 0.33;
        private final String fontFamily = "Arial";

        private double sideLength;
        private Label label;

        public FXTile(double sideLength) {
            initialize(sideLength);
        }

        private void initialize(double sideLength) {
            this.sideLength = sideLength;
            this.setMaxSize(sideLength, sideLength);
            this.setMinSize(sideLength, sideLength);
            setAlignment(Pos.CENTER);
            initLabel();
        }

        private void initLabel() {
            label = new Label();
            label.setFont(Font.font(fontFamily, getFontSize()));
            getChildren().addAll(label);
        }

        public double getFontSize() {
            return sideLength * fontRatio;
        }

    }

}
