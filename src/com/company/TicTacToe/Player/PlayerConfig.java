package com.company.TicTacToe.Player;

import com.company.Core.InputGeneration.InputGenerator;
import com.company.TicTacToe.ObservableBoard.Mark;

public class PlayerConfig {

    private final InputGenerator generator;
    private final MarkFieldService markService;
    private final Mark mark;

    public PlayerConfig(InputGenerator generator, MarkFieldService markService, Mark mark) {
        this.generator = generator;
        this.markService = markService;
        this.mark = mark;
    }

    public Mark getMark() {
        return mark;
    }

    public InputGenerator getGenerator() {
        return generator;
    }

    public MarkFieldService getMarkService() {
        return markService;
    }
}
