package GuiGaming.GuiPlayerImp;

import Api.MarkFieldService;
import Board.Mark;
import Data.Field.Field;
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
