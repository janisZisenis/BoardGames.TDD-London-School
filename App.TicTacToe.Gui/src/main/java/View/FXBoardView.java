package View;

import GuiGaming.TicTacToePresenter.Api.BoardViewDelegate;
import Domain.Data.BoardBoundaries;
import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.Data.Mark;
import GuiGaming.TicTacToePresenter.BoardView;
import Mapping.MarkToStringMapper;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.HashMap;

public class FXBoardView extends Pane implements BoardView {

    private final HashMap<Field, FXTile> tiles = new HashMap<>();
    private final HashMap<FXTile, Field> fields = new HashMap<>();

    private final int sideLength;
    private final int rowColumnCount = BoardBoundaries.rowColumnCount;
    private final MarkToStringMapper mapper;

    private BoardViewDelegate delegate;

    public FXBoardView(MarkToStringMapper mapper) {
        this.sideLength = getRoundedSideLength(250);
        this.mapper = mapper;

        initTiles();
        setPrefSize(sideLength, sideLength);
    }

    private int getRoundedSideLength(int preferredSideLength) {
        return preferredSideLength / rowColumnCount * rowColumnCount;
    }

    private void initTiles() {
        for(int row = 0; row < rowColumnCount; row++) {
            for(int col = 0; col < rowColumnCount; col++ ) {
                FXTile t = makeTile(row, col);
                Field f = new Field(row, col);
                addTile(f, t);
            }
        }
    }

    private FXTile makeTile(int row, int col) {
        int tileLength = sideLength / rowColumnCount;
        FXTile tile = new FXTile(tileLength);
        tile.setTranslateX((double)(col * sideLength / rowColumnCount));
        tile.setTranslateY((double)(row * sideLength / rowColumnCount));
        tile.setClickedDelegate(this);
        return tile;
    }

    private void addTile(Field f, FXTile t) {
        tiles.put(f, t);
        fields.put(t ,f);
        getChildren().add(t);
    }


    public void setDelegate(BoardViewDelegate delegate) {
        this.delegate = delegate;
    }

    private void onTileClicked(FXTile tile) {
        if(delegate ==  null)
            return;

        Field f = fields.get(tile);
        int row = f.getRow();
        int col = f.getColumn();

        delegate.onBoardClicked(row, col);
    }



    public void setField(Field field, Mark mark) {
        String text = mapper.map(mark);
        setFieldText(field, text);
    }

    public void clear(Field field) {
        setFieldText(field, "");
    }

    private void setFieldText(Field field, String text) {
        FXTile tile = tiles.get(field);
        tile.setText(text);
    }

    public void highLight(Line line) {
        highlightLine(line);
        lowlightOtherFields(line);
    }

    private void highlightLine(Line line) {
        highlightField(line.getFirst());
        highlightField(line.getSecond());
        highlightField(line.getThird());
    }

    private void highlightField(Field f) {
        FXTile tile = tiles.get(f);
        tile.highlight();
    }

    private void lowlightOtherFields(Line line) {
        for(Field f : tiles.keySet())
            if(!lineContains(line, f))
                lowlightField(f);
    }

    private boolean lineContains(Line line, Field f) {
        Field first = line.getFirst();
        Field second = line.getSecond();
        Field third = line.getThird();

        return first.equals(f) || second.equals(f) || third.equals(f);
    }

    private void lowlightField(Field f) {
        FXTile tile = tiles.get(f);
        tile.lowlight();
    }

    private class FXTile extends StackPane {

        private final double fontRatio = 0.33;
        private final double fontHighlightRatio = 0.9;
        private final double fontLowlightRatio = 0.1;
        private final String fontFamily = "Arial";
        private final int duration = 500;

        private int sideLength;
        private Label label;
        private Rectangle border;
        private FXTextSizeTransition growing;
        private FXTextSizeTransition shrinking;
        private FXBoardView delegate = null;


        public FXTile(int sideLength) {
            initialize(sideLength);
        }

        private void initialize(int sideLength) {
            this.sideLength = sideLength;

            initLabel();
            initTextSizeTransitions();
            initBorder(sideLength);
            addControls();
            registerClickedHandler();

            setAlignment(Pos.CENTER);
        }

        private void initLabel() {
            label = new Label();
            label.setFont(Font.font(fontFamily, getFontSize()));
        }

        private void initTextSizeTransitions() {
            growing = new FXTextSizeTransition(label, getFontSize(), getHighlightSize(), duration);
            shrinking = new FXTextSizeTransition(label, getFontSize(), getLowlightSize(), duration);
        }

        private void initBorder(int sideLength) {
            border = new Rectangle(sideLength, sideLength);
            border.setFill(null);
            border.setStroke(Color.BLACK);
        }

        private void addControls() {
            getChildren().addAll(label, border);
        }

        private void registerClickedHandler() {
            setOnMouseClicked(e -> onMouseClicked());
        }

        private void onMouseClicked() {
            if(delegate != null)
                delegate.onTileClicked(this);
        }

        public void setText(String s) {
            label.setText(s);
        }

        public void highlight() {
            growing.play();
        }

        public void lowlight() {
            shrinking.play();
        }

        public int getFontSize() {
            return (int)(sideLength * fontRatio);
        }

        public int getHighlightSize() {
            return (int)(sideLength * fontHighlightRatio);
        }

        private int getLowlightSize() {
            return (int)(sideLength * fontLowlightRatio);
        }

        public void setClickedDelegate(FXBoardView delegate) {
            this.delegate = delegate;
        }
    }

}
