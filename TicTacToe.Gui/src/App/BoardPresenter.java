package App;

import Board.Board;
import Board.Mark;
import Data.Field.Field;
import Gaming.BoardRenderer.BoardView;
import Gaming.Input.Input;
import GuiGaming.GuiPlayerImp.GuiPlayerImp;
import GuiGaming.GuiTurn.GuiPlayer;
import GuiGaming.GuiTurn.GuiTwoPlayerTurn;

public class BoardPresenter implements BoardDelegate {

    private BoardView view;
    private GuiTwoPlayerTurn turn;

    public BoardPresenter(BoardView view, Board board) {
        this.view = view;
        initGame(board);
    }

    private void initGame(Board board) {
        GuiPlayer john = new GuiPlayerImp(Mark.John, board);
        GuiPlayer haley = new GuiPlayerImp(Mark.Haley, board);
        turn = new GuiTwoPlayerTurn(john, haley);
    }

    public void onInputGenerated(Input input) {
        Field f = makeField(input);
        turn.process(f);

        view.showBoard();
    }

    private Field makeField(Input input) {
        int row = input.getRow();
        int col = input.getColumn();
        return new Field(row, col);
    }

}
