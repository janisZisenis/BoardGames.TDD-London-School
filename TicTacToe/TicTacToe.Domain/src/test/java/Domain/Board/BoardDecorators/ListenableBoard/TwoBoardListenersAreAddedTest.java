package Domain.Board.BoardDecorators.ListenableBoard;

import Domain.Board.BoardDummy;
import Domain.Data.Field.Field;
import Domain.Data.Mark;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TwoBoardListenersAreAddedTest {

    private BoardDummy board = new BoardDummy();
    private BoardListenerSpy first = new BoardListenerSpy();
    private BoardListenerSpy second = new BoardListenerSpy();
    private ListenableBoard sut = new ListenableBoard(board);

    private Mark mark = Mark.John;

    private Field field = new Field(0, 1);


    @BeforeEach
    void Setup() {
        sut.addListener(first);
        sut.addListener(second);
    }

    @Test
    void IfR0C1GetsMarked_ItShouldUpdatedFirstR0C1() {

        sut.mark(field, mark);

        assertWasUpdated(first);
    }

    @Test
    void IfR0C1GetsMarked_ItShouldUpdatedSecondR0C1() {
        Field field = new Field(0, 1);

        sut.mark(field, mark);

        assertWasUpdated(second);
    }

    @Test
    void IfGetsCleared_ItShouldClearSecond() {
        sut.clear();

        assertWasCleared(second);
    }

    private void assertWasCleared(BoardListenerSpy listener) {
        boolean actual = listener.wasCleared();
        assertTrue(actual);
    }

    private void assertWasUpdated(BoardListenerSpy listener) {
        boolean actual = listener.wasUpdated();
        assertTrue(actual);
    }

}
