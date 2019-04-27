package Lib.Model.Players;

import Lib.Data.Field.Field;
import Lib.Data.Input.Input;
import Lib.Data.Mark;
import Lib.Model.GameLoop.GameImp.TwoPlayerTurn.Player;

public class PlayerImp implements Player {

    private final MarkFieldService markService;
    private final Mark mark;
    private final InputGenerator generator;

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

    private void mark(Field f) {
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
