package App;

import Domain.Board.ListenableBoard.BoardListener;
import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.Data.Mark;
import GuiGaming.TicTacToePresenter.TicTacToe;
import InputGeneration.Input.Input;
import View.FXBoardView;

public class TicTacToePresenter implements BoardViewDelegate, BoardListener {

    private final FXBoardView view;
    private final TicTacToe tictactoe;

    public void onFieldUpdated(Field field) {
        updateField(field);

        if(tictactoe.hasWinner()) {
            Line line = tictactoe.getWinningLine();
            showWinningLine(line);
        }

    }

    private void showWinningLine(Line line) {
        view.showWinningLine(line);
    }

    private void updateField(Field field) {
        if(tictactoe.isMarked(field)) {
            Mark m = tictactoe.getMarkAt(field);
            view.setFieldMark(field, m);
        }
    }

    public TicTacToePresenter(FXBoardView view, TicTacToe ticTacToe) {
        this.view = view;
        this.tictactoe = ticTacToe;
    }

    public void onTileClicked(int row, int column) {
        Input input = new Input(row, column);
        tictactoe.process(input);
    }

}
