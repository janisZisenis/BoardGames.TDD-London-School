package Domain.Board.BoardDecorators;

import Domain.Board.Board;
import Domain.Board.BoardStub;

public class BoardDecoratorContext {

    private final BoardStub decoree;
    private final Board sut;

    public BoardDecoratorContext(Board sut, BoardStub decoree) {
        this.sut = sut;
        this.decoree = decoree;
    }

    public Board getSut() {
        return sut;
    }

    public BoardStub getDecoree() {
        return decoree;
    }


}
