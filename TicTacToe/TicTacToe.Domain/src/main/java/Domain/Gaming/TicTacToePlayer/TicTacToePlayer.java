package Domain.Gaming.TicTacToePlayer;

import Domain.Data.Field.Field;
import Domain.Data.Mark;
import Gaming.GameFacade.Player;
import InputGeneration.Input.Input;
import InputGeneration.InputGenerator;

public class TicTacToePlayer implements Player {

    private final Mark mark;
    private final MarkFieldService service;
    private final InputGenerator generator;

    public TicTacToePlayer(Mark mark, MarkFieldService service, InputGenerator generator) {
        this.mark = mark;
        this.service = service;
        this.generator = generator;
    }

    public void play() {
        Input input = generate();
        Field f = makeField(input);
        mark(f);
    }

    private Field makeField(Input input) {
        int row = input.getRow();
        int col = input.getColumn();

        return new Field(row, col);
    }

    private void mark(Field f) {
        service.mark(f, mark);
    }

    private Input generate() {
        return generator.generate();
    }
}
