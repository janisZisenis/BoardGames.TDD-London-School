package com.company.Model.Players;

import com.company.Data.Input.Input;
import com.company.Model.GameLoop.TwoPlayerTurn.Player;
import com.company.Data.Mark;
import com.company.Data.Field.Field;

public class PlayerImp implements Player {

    private final MarkFieldService markService;
    private final Mark mark;
    private final InputGenerator generator;

    public PlayerImp(PlayerContext config) {
        this.generator = config.getGenerator();
        this.markService = config.getMarkService();
        this.mark = config.getMark();
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
