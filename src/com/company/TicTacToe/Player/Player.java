package com.company.TicTacToe.Player;

import com.company.Core.InputGeneration.Input;
import com.company.Core.InputGeneration.InputGenerator;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Field;

public class Player {

    private final MarkFieldService markService;
    private final Mark mark;
    private final InputGenerator generator;

    public Player(InputGenerator generator, MarkFieldService markService, Mark mark) {
        this.generator = generator;
        this.markService = markService;
        this.mark = mark;
    }

    public void play() {
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
