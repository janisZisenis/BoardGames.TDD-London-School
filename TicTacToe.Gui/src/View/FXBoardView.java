package View;

import Lib.Board.ReadOnlyBoard;
import Lib.BoardRenderer.BoardView;
import Lib.Data.BoardBoundaries;
import Lib.Data.Field.Field;
import Lib.Data.Line;
import Lib.Data.Mark;
import Lib.MarkToStringMapper.MarkToStringMapper;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

import java.util.HashMap;

public class FXBoardView extends Pane implements BoardView {

    private final HashMap<Field, FXTile> tiles = new HashMap<Field, FXTile>();

    private final Font normal = Font.font("Arial", 20);
    private final Font winning = Font.font("Arial Bold", 40);

    private final int sideLength;
    private final int rowColumnCount = BoardBoundaries.rowColumnCount;

    private final ReadOnlyBoard board;
    private final MarkToStringMapper mapper;

    public FXBoardView(int preferredSideLength, ReadOnlyBoard board, MarkToStringMapper mapper) {
        this.board = board;
        this.mapper = mapper;

        this.sideLength = getRoundedSideLength(preferredSideLength);
        setPrefSize(sideLength, sideLength);
        initTiles();
    }

    private int getRoundedSideLength(int preferredSideLength) {
        return preferredSideLength / rowColumnCount * rowColumnCount;
    }

    private void initTiles() {
        for(int row = 0; row < rowColumnCount; row++) {
            for(int col = 0; col < rowColumnCount; col++ ) {
                FXTile t = makeTile();
                t.setTranslateX(col * sideLength / rowColumnCount);
                t.setTranslateY(row * sideLength / rowColumnCount);

                getChildren().add(t);
                tiles.put(new Field(row, col), t);
            }
        }
    }

    private FXTile makeTile() {
        int tileLength = sideLength / rowColumnCount;
        return new FXTile(tileLength);
    }

    public void showBoard() {
        for(int row = 0; row < rowColumnCount; row++) {
            for(int col = 0; col < rowColumnCount; col++) {
                Field f = new Field(row, col);
                if(board.isMarked(f))
                    setFieldText(f, normal);
            }
        }
    }

    public void showWinningLine(Line line) {
        showBoard();
        highlight(line);
    }

    private void highlight(Line line) {
        setFieldText(line.getFirst(), winning);
        setFieldText(line.getSecond(), winning);
        setFieldText(line.getThird(), winning);
    }

    private void setFieldText(Field field, Font font) {
        Mark m = board.getMarkAt(field);
        String s = mapper.map(m);
        tiles.get(field).setText(s, font);
    }
}
