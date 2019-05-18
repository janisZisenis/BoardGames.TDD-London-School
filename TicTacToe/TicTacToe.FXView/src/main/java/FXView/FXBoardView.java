package FXView;

import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.Data.Mark;
import Mapping.MarkToStringMappers.MarkToXOMapper;
import Presentation.BoardViewPresenter.Api.BoardViewDelegate;
import Presentation.BoardViewPresenter.BoardView;
import Presentation.WinningLinePresenter.WinningLineView;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;

import java.util.HashMap;

public class FXBoardView extends FXGameView implements BoardView, WinningLineView {

    private final int rowColumnCount;

    private final GridPane board = new GridPane();
    private final int padding = 5;
    private final String borderColor = "#4a4549";
    private final String tileColor = "#f0ffff";

    private final HashMap<Field, FXTile> tiles = new HashMap<>();
    private final HashMap<FXTile, Field> fields = new HashMap<>();

    private final MarkToXOMapper mapper = new MarkToXOMapper();
    private BoardViewDelegate delegate;


    public void setDelegate(BoardViewDelegate delegate) {
        this.delegate = delegate;
    }


    public FXBoardView(int rowColumnCount) {
        this.rowColumnCount = rowColumnCount;

        init();
        registerShowListener();
    }

    private void init() {
        applyBoardStyle();
        getChildren().add(board);
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
                Field f = new Field(row, col);
                FXTile t = makeTile(tileLength);
                tiles.put(f, t);
                fields.put(t ,f);
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

    public void setField(Field field, Mark m) {
        Platform.runLater(() -> {
            String text = mapper.map(m);
            setFieldText(field, text);
        });
    }

    public void clearField(Field field) {
        setFieldText(field, "");
    }

    private void setFieldText(Field field, String text) {
        FXTile tile = tiles.get(field);
        tile.setText(text);
    }


    private void onTileClicked(FXTile tile) {
        if(delegate ==  null)
            return;

        Field f = fields.get(tile);
        int row = f.getRow();
        int col = f.getColumn();

        delegate.onBoardClicked(row, col);
    }

    public void highlightLine(Line line) {
        highlight(line);
        lowlightOtherFields(line);
    }

    private void highlight(Line line) {
        magnifyField(line.getFirst());
        magnifyField(line.getSecond());
        magnifyField(line.getThird());
    }

    private void magnifyField(Field f) {
        FXTile tile = tiles.get(f);
        tile.magnify();
    }

    private void lowlightOtherFields(Line line) {
        for(Field f : tiles.keySet())
            if(!lineContains(line, f))
                minimizeField(f);
    }

    private boolean lineContains(Line line, Field f) {
        Field first = line.getFirst();
        Field second = line.getSecond();
        Field third = line.getThird();

        return first.equals(f) || second.equals(f) || third.equals(f);
    }

    private void minimizeField(Field f) {
        FXTile tile = tiles.get(f);
        tile.minimize();
    }

    private class FXTile extends StackPane {

        private final double fontRatio = 0.33;
        private final double fontHighlightRatio = 0.9;
        private final double fontLowlightRatio = 0.1;
        private final int duration = 500;
        private final String fontFamily = "Arial";
        private final Label label = new Label();

        private final FXTextSizeTransition growing;
        private final FXTextSizeTransition shrinking;

        private final double sideLength;

        public FXTile(double sideLength) {
            this.sideLength = sideLength;
            growing = new FXTextSizeTransition(label, getFontSize(), getHighlightSize(), duration);
            shrinking = new FXTextSizeTransition(label, getFontSize(), getLowlightSize(), duration);

            init();
        }

        private void init() {
            this.setMaxSize(sideLength, sideLength);
            this.setMinSize(sideLength, sideLength);
            setAlignment(Pos.CENTER);
            initLabel();
            registerClickedHandler();
        }

        private void registerClickedHandler() {
            setOnMouseClicked(e -> onTileClicked(this));
        }


        private void initLabel() {
            label.setFont(Font.font(fontFamily, getFontSize()));
            getChildren().addAll(label);
        }

        public double getFontSize() {
            return sideLength * fontRatio;
        }

        public void setText(String s) {
            label.setText(s);
        }

        public void magnify() {
            growing.play();
        }

        public void minimize() {
            shrinking.play();
        }

        public int getHighlightSize() {
            return (int)(sideLength * fontHighlightRatio);
        }

        private int getLowlightSize() {
            return (int)(sideLength * fontLowlightRatio);
        }


    }

}
