package com.company.TicTacToe.TicTacToePlayer;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputGenerator;
import com.company.Core.GameLoop.TwoPlayerTurn.Player;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Board.Field.Field;

public class TicTacToePlayer implements Player {

    private final MarkFieldService markService;
    private final Mark mark;
    private final InputGenerator generator;

    public TicTacToePlayer(PlayerContext config) {
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
