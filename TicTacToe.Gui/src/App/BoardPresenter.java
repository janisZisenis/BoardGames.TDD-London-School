package App;

import Board.Board;
import Board.Mark;
import Data.Field.Field;
import Gaming.BoardRenderer.BoardView;
import Gaming.Input.Input;
import GuiGaming.GuiPlayer;

public class BoardPresenter implements BoardDelegate {

    private BoardView view;

    private GuiPlayer john;
    private GuiPlayer haley;
    private GuiPlayer current;

    public BoardPresenter(BoardView view, Board board) {
        this.view = view;
        initGame(board);
    }

    private void initGame(Board board) {
        john = current = new GuiPlayer(Mark.John, board);
        haley = new GuiPlayer(Mark.Haley, board);
    }

    public void onInputGenerated(Input input) {
        Field f = makeField(input);

        current.mark(f);
        current = current == john ? haley : john;

        view.showBoard();
    }

    private Field makeField(Input input) {
        int row = input.getRow();
        int col = input.getColumn();
        return new Field(row, col);
    }

}
