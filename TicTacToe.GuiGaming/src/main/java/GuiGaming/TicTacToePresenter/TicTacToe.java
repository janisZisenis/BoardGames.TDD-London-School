package GuiGaming.TicTacToePresenter;

import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.Data.Mark;
import InputGeneration.Input.Input;

public interface TicTacToe {
    boolean hasWinner();
    Line getWinningLine();
    void process(Input input);
    boolean isMarked(Field f);
    Mark getMarkAt(Field field);
}
