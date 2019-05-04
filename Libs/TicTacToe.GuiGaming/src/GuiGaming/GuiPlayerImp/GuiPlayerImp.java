package GuiGaming.GuiPlayerImp;

import Data.Field.Field;
import Domain.Board.Api.MarkFieldService;
import Domain.Board.Mark;
import GuiGaming.GuiTurn.GuiPlayer;

public class GuiPlayerImp implements GuiPlayer {

    private final MarkFieldService service;
    private final Mark mark;

    public GuiPlayerImp(Mark mark, MarkFieldService service) {
        this.mark = mark;
        this.service = service;
    }

    public void mark(Field f) {
        service.mark(f, mark);
    }
}
