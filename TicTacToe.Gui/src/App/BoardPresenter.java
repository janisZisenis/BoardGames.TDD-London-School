package App;

import Board.Board;
import Board.Mark;
import Gaming.BoardRenderer.BoardView;
import Gaming.Input.Input;
import Data.Field.Field;

public class BoardPresenter implements BoardDelegate {

    private BoardView view;

    private Player john;
    private Player haley;
    private Player current;

    public BoardPresenter(BoardView view, Board board) {
        this.view = view;
        initGame(board);
    }

    private void initGame(Board board) {
        john = current = new Player(Mark.John, board);
        haley = new Player(Mark.Haley, board);
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
