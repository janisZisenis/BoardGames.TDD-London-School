package GuiGaming.TicTacToeGuiPlayer;

import Domain.Data.Field.Field;
import Domain.Data.Mark;
import Domain.TicTacToePlayer.MarkFieldService;
import GuiGaming.MultiGuiPlayer.GuiPlayer;
import InputGeneration.Input.Input;

public class TicTacToeGuiPlayer implements GuiPlayer {

    private final MarkFieldService service;
    private final Mark mark;

    public TicTacToeGuiPlayer(Mark mark, MarkFieldService service) {
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
