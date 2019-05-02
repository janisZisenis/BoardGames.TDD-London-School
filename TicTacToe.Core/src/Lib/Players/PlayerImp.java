package Lib.Players;

import Lib.Data.Field.Field;
import Lib.Data.Input.Input;
import Lib.Data.Mark;
import Lib.TwoPlayerTurn.Player;

public class PlayerImp implements Player {

    private final MarkFieldService markService;
    private final InputGenerator generator;
    protected final Mark mark;

    public PlayerImp(PlayerContext context) {
        this.generator = context.getGenerator();
        this.markService = context.getMarkService();
        this.mark = context.getMark();
    }

    public void playMove() {
        Input in = generateInput();
        Field f = makeField(in);
        mark(f);
    }

    protected void mark(Field f) {
        markService.mark(f, mark);
    }

    private Field makeField(Input in) {
        int row = in.getRow();
        int col = in.getColumn();

        return new Field(row, col);
    }

    private Input generateInput() {
        return generator.generate();
    }
}
