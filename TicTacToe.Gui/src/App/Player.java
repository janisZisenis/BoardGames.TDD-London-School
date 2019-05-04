package App;

import Api.MarkFieldService;
import Board.Mark;
import Data.Field.Field;

public class Player {

    private final Mark m;
    private final MarkFieldService service;

    public Player(Mark m, MarkFieldService service) {
        this.m = m;
        this.service = service;
    }

    public void mark(Field f) {
        service.mark(f, m);
    }

}
