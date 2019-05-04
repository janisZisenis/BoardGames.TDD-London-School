package GuiGaming;

import Api.MarkFieldService;
import Board.Mark;
import Data.Field.Field;

public class GuiPlayer {


    private final MarkFieldService service;
    private final Mark mark;

    public GuiPlayer(Mark mark, MarkFieldService service) {
        this.mark = mark;
        this.service = service;
    }

    public void mark(Field f) {
        service.mark(f, mark);
    }
}
