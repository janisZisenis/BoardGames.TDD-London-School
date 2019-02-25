package com.company.TicTacToe.Player;

import com.company.Core.InputGeneration.Input;
import com.company.Core.InputGeneration.InputGenerator;
import com.company.TicTacToe.Board.Player;
import com.company.TicTacToe.Field;

public class John {
    private final InputGenerator generator;
    private final MarkFieldService markService;

    public John(InputGenerator generator, MarkFieldService markService) {
        this.generator = generator;
        this.markService = markService;
    }

    public void play() {
        Input in = generator.generateInput();
        Field f = new Field(in.getRow(), in.getColumn());
        markService.mark(f, Player.John);
    }
}
