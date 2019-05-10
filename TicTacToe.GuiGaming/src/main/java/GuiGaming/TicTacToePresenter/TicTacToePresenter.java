package GuiGaming.TicTacToePresenter;

import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.Data.Mark;
import InputGeneration.Input.Input;

public class TicTacToePresenter {

    private final TicTacToe tictactoe;
    private final BoardView view;

    public TicTacToePresenter(TicTacToe tictactoe, BoardView view) {
        this.tictactoe = tictactoe;
        this.view = view;
    }

    public void onBoardClicked(int row, int col) {
        Input i = new Input(row, col);
        tictactoe.process(i);
    }

    public void onFieldUpdated(Field field) {
        update(field);

        showWinningLineIfProvided();
    }

    private void showWinningLineIfProvided() {
        if(tictactoe.hasWinner()) {
            Line line = tictactoe.getWinningLine();
            view.highlightLine(line);
        }
    }

    private void update(Field field) {
        if(isMarked(field))
            setField(field);
        else
            clear(field);
    }

    private void setField(Field field) {
        Mark m = tictactoe.getMarkAt(field);
        view.setField(field, m);
    }

    private boolean isMarked(Field field) {
        return tictactoe.isMarked(field);
    }

    private void clear(Field field) {
        view.clear(field);
    }
}
