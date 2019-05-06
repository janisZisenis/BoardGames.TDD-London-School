package Domain.Turn;

import Domain.Data.Field.Field;
import Domain.Data.Mark;

public class TicTacToeTurn {

    private final Mark mark;
    private final MarkFieldService service;
    private final FieldGenerator strategy;

    public TicTacToeTurn(Mark mark, MarkFieldService service, FieldGenerator strategy) {
        this.mark = mark;
        this.service = service;
        this.strategy = strategy;
    }

    public void play() {
        Field f = generate();
        mark(f);
    }

    private void mark(Field f) {
        service.mark(f, mark);
    }

    private Field generate() {
        return strategy.generate();
    }
}
