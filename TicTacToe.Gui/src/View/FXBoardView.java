package View;

import Board.BoardBoundaries;
import Board.HashingBoard.HashingBoard;
import Board.Mark;
import Data.Field.Field;
import Data.Line.Line;
import Mappers.MarkToStringMapper;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

import java.util.HashMap;

public class FXBoardView extends Pane {

    private final HashMap<Field, FXTile> tiles = new HashMap<>();
    private final HashMap<FXTile, Field> fields = new HashMap<>();

    private final int sideLength;
    private final int rowColumnCount = BoardBoundaries.rowColumnCount;

    private final HashingBoard board;
    private final MarkToStringMapper mapper;

    public FXBoardView(int prefSideLength, HashingBoard board, MarkToStringMapper mapper) {
        this.board = board;
        this.mapper = mapper;
        this.sideLength = getRoundedSideLength(prefSideLength);

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

    public void showBoard() {
        for(int row = 0; row < rowColumnCount; row++) {
            for(int col = 0; col < rowColumnCount; col++) {
                Field f = new Field(row, col);
                updateField(f);
            }
        }
    }

    private void updateField(Field field) {
        if(board.isMarked(field)) {
            Mark m = board.getMarkAt(field);
            String s = mapper.map(m);
            tiles.get(field).setText(s);
        }
    }

    public void showWinningLine(Line line) {
        showBoard();
        highlight(line);
        lowlightOther(line);
    }

    private void highlight(Line line) {
        tiles.get(line.getFirst()).highlight();
        tiles.get(line.getSecond()).highlight();
        tiles.get(line.getThird()).highlight();
    }

    private void lowlightOther(Line line) {
        for(int i = 0; i < rowColumnCount; i++) {
            for(int j = 0; j < rowColumnCount; j++) {
                Field f = new Field(i, j);
                if(!lineContainsField(line, f))
                    tiles.get(f).lowlight();
            }
        }
    }

    private boolean lineContainsField(Line line, Field f) {
        Field first = line.getFirst();
        Field second = line.getSecond();
        Field third = line.getThird();

        return first.equals(f) || second.equals(f) || third.equals(f);
    }

    int counter = 0;
    private void onTileClicked(FXTile tile) {
        Field f = fields.get(tile);
        Mark m = Mark.John;
        if(counter % 2 != 0)
            m = Mark.Haley;

        board.mark(f, m);
        showBoard();
        counter++;
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
