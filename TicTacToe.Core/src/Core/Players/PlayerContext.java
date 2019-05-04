package Core.Players;

import Api.MarkFieldService;
import Board.Mark;

public class PlayerContext {

    private final InputGenerator generator;
    private final MarkFieldService markService;
    private final Mark mark;

    public PlayerContext(InputGenerator generator, MarkFieldService markService, Mark mark) {
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
