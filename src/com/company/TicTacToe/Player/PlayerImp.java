package com.company.TicTacToe.Player;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputGenerator;
import com.company.TicTacToe.Field.Field;
import com.company.TicTacToe.Game.Player;
import com.company.TicTacToe.Mark;

public class PlayerImp implements Player {

    private final MarkFieldService markService;
    private final Mark mark;
    private final InputGenerator generator;

    public PlayerImp(PlayerImpConfig config) {
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
        return generator.generateInput();
    }
}
