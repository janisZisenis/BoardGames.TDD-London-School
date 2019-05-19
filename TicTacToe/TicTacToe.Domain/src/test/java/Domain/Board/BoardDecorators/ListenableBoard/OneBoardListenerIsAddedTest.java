package Domain.Board.BoardDecorators.ListenableBoard;

import Domain.Board.BoardDummy;
import Domain.Data.Field.Field;
import Domain.Data.Mark;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OneBoardListenerIsAddedTest {

    private BoardDummy board = new BoardDummy();
    private BoardListenerSpy listener = new BoardListenerSpy();
    private ListenableBoard sut = new ListenableBoard(board);

    private Mark mark = Mark.John;

    @BeforeEach
    void Setup() {
        sut.addListener(listener);
    }

    @Test
    void IfR0C1GetsMarked_ItShouldUpdatedR0C1() {
        Field field = new Field(0, 1);

        sut.mark(field, mark);

        assertUpdatedFieldEquals(field);
    }

    @Test
    void IfR2C0GetsMarked_ItShouldUpdatedR2C0() {
        Field field = new Field(2, 0);

        sut.mark(field, mark);

        assertUpdatedFieldEquals(field);
    }

    @Test
    void IfGetsCleared_ItShouldClearListener() {
        sut.clear();

        assertWasCleared();
    }


    private void assertUpdatedFieldEquals(Field expected) {
        Field actual = listener.getUpdatedField();
        assertEquals(expected, actual);
    }

    private void assertWasCleared() {
        boolean actual = listener.wasCleared();
        assertTrue(actual);
    }

}
