package com.company.TicTacToe.Player;

import com.company.Core.InputGeneration.Input;
import com.company.Core.InputGeneration.InputGenerator;
import com.company.TicTacToe.Board.Player;
import com.company.TicTacToe.Field;

public class Haley {

    private final MarkFieldService markService;
    private final InputGenerator generator;

    public Haley(InputGenerator generator, MarkFieldService markService) {
        this.generator = generator;
        this.markService = markService;
    }

    public void play() {
        Input in = generateInput();
        Field f = makeField(in);
        markFie(f);
    }

    private void markFie(Field f) {
        markService.mark(f, Player.Haley);
    }

    private Input generateInput() {
        return generator.generateInput();
    }

    private Field makeField(Input in) {
        return new Field(in.getRow(), in.getColumn());
    }
}
