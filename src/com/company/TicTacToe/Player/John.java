package com.company.TicTacToe.Player;

import com.company.Core.InputGeneration.Input;
import com.company.Core.InputGeneration.InputGenerator;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.Field;

public class John {

    private final Player p;

    public John(InputGenerator generator, MarkFieldService markService) {
        this.p = new Player(generator, markService, Mark.John);
    }

    public void play() {
        p.play();
    }

    private class Player {
        private final MarkFieldService markService;
        private final InputGenerator generator;
        private final Mark mark;

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

        private Input generateInput() {
            return generator.generateInput();
        }

        private Field makeField(Input in) {
            return new Field(in.getRow(), in.getColumn());
        }
    }
}
