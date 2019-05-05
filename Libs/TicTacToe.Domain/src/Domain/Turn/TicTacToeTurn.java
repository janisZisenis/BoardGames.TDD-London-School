package Domain.Turn;

import Domain.Data.Field.Field;
import Domain.Data.Mark;

public class TicTacToeTurn {

    private final Mark mark;
    private final MarkFieldService service;
    private final InputFieldStrategy strategy;

    public TicTacToeTurn(Mark mark, MarkFieldService service, InputFieldStrategy strategy) {
        this.mark = mark;
        this.service = service;
        this.strategy = strategy;
    }

    public void play() {
        Field f = generateField();
        mark(f);
    }

    private void mark(Field f) {
        service.mark(f, mark);
    }

    private Field generateField() {
        return strategy.generateField();
    }
}
