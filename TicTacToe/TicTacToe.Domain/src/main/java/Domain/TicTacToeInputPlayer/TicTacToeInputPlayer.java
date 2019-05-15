package Domain.TicTacToeInputPlayer;

import Domain.Data.Field.Field;
import Domain.Data.Mark;
import Domain.TicTacToePlayer.MarkFieldService;
import InputGeneration.Input.Input;
import InteractiveGaming.HybridInputPlayerAdapter.InputPlayer;

public class TicTacToeInputPlayer implements InputPlayer {

    private final MarkFieldService service;
    private final Mark mark;

    public TicTacToeInputPlayer(Mark mark, MarkFieldService service) {
        this.mark = mark;
        this.service = service;
    }

    public void play(Input input) {
        Field f = makeField(input);
        service.mark(f, mark);
    }

    private Field makeField(Input input) {
        int row = input.getRow();
        int col = input.getColumn();

        return new Field(row, col);
    }
}
