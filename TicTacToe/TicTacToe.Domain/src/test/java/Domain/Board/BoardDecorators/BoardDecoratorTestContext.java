package Domain.Board.BoardDecorators;

import Domain.Board.Board;
import Domain.Board.BoardSpy;

public class BoardDecoratorTestContext {

    private final BoardSpy decoree;
    private final Board sut;

    public BoardDecoratorTestContext(Board sut, BoardSpy decoree) {
        this.sut = sut;
        this.decoree = decoree;
    }

    public Board getSut() {
        return sut;
    }

    public BoardSpy getDecoree() {
        return decoree;
    }


}
