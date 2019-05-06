package GuiGaming.GuiPlayerImp;

import Domain.Data.Field.Field;
import Domain.Data.Mark;
import Domain.Turn.MarkFieldService;
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
