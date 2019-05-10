package GuiGaming.GuiTicTacToePlayer;

import Domain.Data.Field.Field;
import Domain.Data.Mark;
import Domain.TicTacToePlayer.MarkFieldService;
import GuiGaming.GuiPlayer;

public class GuiTicTacToePlayer implements GuiPlayer {

    private final MarkFieldService service;
    private final Mark mark;

    public GuiTicTacToePlayer(Mark mark, MarkFieldService service) {
        this.mark = mark;
        this.service = service;
    }

    public void play(Field f) {
        service.mark(f, mark);
    }
}
