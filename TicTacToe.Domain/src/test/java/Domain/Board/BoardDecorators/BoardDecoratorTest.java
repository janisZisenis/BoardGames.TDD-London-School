package Domain.Board.BoardDecorators;

import Domain.Board.Board;
import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Board.BoardDecorators.ObservableBoard.ObservableBoard;
import Domain.Board.BoardStub;
import Domain.Data.Field.Field;
import Domain.Data.Mark;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BoardDecoratorTest {

    private BoardStub decoree;
    private Board sut;


    public static Stream<BoardDecoratorContext> makeBoards() {
        return Stream.of(
                makeListenableBoardContext(),
                makeObservableBoardContext()
        );
    }

    private static BoardDecoratorContext makeListenableBoardContext() {
        BoardStub decoree = new BoardStub();
        ListenableBoard sut = new ListenableBoard(decoree);
        return new BoardDecoratorContext(sut, decoree);
    }

    private static BoardDecoratorContext makeObservableBoardContext() {
        BoardStub decoree = new BoardStub();
        ObservableBoard sut = new ObservableBoard(decoree);
        return new BoardDecoratorContext(sut, decoree);
    }

    private void arrange(BoardDecoratorContext cxt) {
        this.decoree = cxt.getDecoree();
        this.sut = cxt.getSut();
    }

    private void annihilate() {
        this.decoree = null;
        this.sut = null;
    }

    @ParameterizedTest
    @MethodSource("makeBoards")
    void IfR0C0IsEmptyOnTheBoard_R0C0ShouldBeEmptyEither(BoardDecoratorContext cxt) {
        arrange(cxt);
        makeFieldIsEmpty(new Field(0, 0));

        assertIsEmpty(new Field(0, 0));

        annihilate();
    }

    @ParameterizedTest
    @MethodSource("makeBoards")
    void IfR1C2IsEmptyOnTheBoard_R1C2ShouldBeEmptyEither(BoardDecoratorContext cxt) {
        arrange(cxt);
        makeFieldIsEmpty(new Field(1, 2));

        assertIsEmpty(new Field(1, 2));

        annihilate();
    }

    @ParameterizedTest
    @MethodSource("makeBoards")
    void IfR0C0IsNotEmptyOnTheBoard_R0C0ShouldBeNotEmptyEither(BoardDecoratorContext cxt) {
        arrange(cxt);

        assertIsNotEmpty(new Field(0, 0));

        annihilate();
    }

    private void assertIsEmpty(Field field) {
        boolean actual = sut.isEmpty(field);
        assertTrue(actual);
    }

    private void assertIsNotEmpty(Field field) {
        boolean actual = sut.isEmpty(field);
        assertFalse(actual);
    }

    private void makeFieldIsEmpty(Field field) {
        Field[] fields = new Field[] { field };
        decoree.setEmptyFields(fields);
    }


    @ParameterizedTest
    @MethodSource("makeBoards")
    void IfR0C0IsMarkedOnTheBoard_R0C0ShouldBeMarkedEither(BoardDecoratorContext cxt) {
        arrange(cxt);
        makeFieldIsMarked(new Field(0, 0));

        assertIsMarked(new Field(0, 0));

        annihilate();
    }

    @ParameterizedTest
    @MethodSource("makeBoards")
    void IfR1C2IsMarkedOnTheBoard_R1C2ShouldBeMarkedEither(BoardDecoratorContext cxt) {
        arrange(cxt);
        makeFieldIsMarked(new Field(1, 2));

        assertIsMarked(new Field(1, 2));

        annihilate();
    }

    @ParameterizedTest
    @MethodSource("makeBoards")
    void IfFieldIsNotMarkedOnTheBoard_ItShouldBeNotMarkedEither(BoardDecoratorContext cxt) {
        arrange(cxt);

        assertIsNotMarked(new Field(0, 0));

        annihilate();
    }

    private void assertIsMarked(Field field) {
        boolean actual = sut.isMarked(field);
        assertTrue(actual);
    }

    private void assertIsNotMarked(Field field) {
        boolean actual = sut.isMarked(field);
        assertFalse(actual);
    }

    private void makeFieldIsMarked(Field field) {
        Field[] fields = new Field[] { field };
        decoree.setMarkedFields(fields);
    }


    @ParameterizedTest
    @MethodSource("makeBoards")
    void IfBoardHasHaleyOnR0C0_ItShouldHaveHaleyOnR0C0Either(BoardDecoratorContext cxt) {
        arrange(cxt);
        decoree.setMarkOnField(Mark.Haley, new Field(0, 0));

        assertHasHaleyOn(new Field(0, 0));

        annihilate();
    }

    @ParameterizedTest
    @MethodSource("makeBoards")
    void IfBoardHasJohnOnR0C0_ItHaveJohnOnR0C0Either(BoardDecoratorContext cxt) {
        arrange(cxt);
        decoree.setMarkOnField(Mark.John, new Field(0, 0));

        assertHasJohnOn(new Field(0, 0));

        annihilate();
    }

    @ParameterizedTest
    @MethodSource("makeBoards")
    void IfBoardHasJohnOnR1C2_ItHaveJohnOnR1C2Either(BoardDecoratorContext cxt) {
        arrange(cxt);
        decoree.setMarkOnField(Mark.John, new Field(1, 2));

        assertHasJohnOn(new Field(1, 2));

        annihilate();
    }

    private void assertHasHaleyOn(Field field) {
        Mark actual = sut.getMarkAt(field);
        Mark expected = Mark.Haley;
        assertEquals(expected, actual);
    }

    private void assertHasJohnOn(Field field) {
        Mark actual = sut.getMarkAt(field);
        Mark expected = Mark.John;
        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @MethodSource("makeBoards")
    void IfBoardHasNoMarkedFields_ItShouldHaveNoMarkedFieldsEither(BoardDecoratorContext cxt) {
        arrange(cxt);
        decoree.setMarkedFieldCount(0);

        assertMarkedFieldCountIs(0);

        annihilate();
    }

    @ParameterizedTest
    @MethodSource("makeBoards")
    void IfBoardHasOneMarkedFields_ItShouldHaveOneMarkedFieldsEither(BoardDecoratorContext cxt) {
        arrange(cxt);
        decoree.setMarkedFieldCount(1);

        assertMarkedFieldCountIs(1);

        annihilate();
    }

    private void assertMarkedFieldCountIs(int expected) {
        int actual = sut.getMarkedFieldCount();
        assertEquals(expected, actual);
    }


    @ParameterizedTest
    @MethodSource("makeBoards")
    void IfR0C0GetsMarked_ItShouldMarkR0C0OnTheBoard(BoardDecoratorContext cxt) {
        arrange(cxt);
        sut.mark(new Field(0, 0), Mark.John);

        assertMarkedFieldEquals(new Field(0, 0));
    }

    @ParameterizedTest
    @MethodSource("makeBoards")
    void IfR1C2GetsMarked_ItShouldMarkR1C2OnTheBoard(BoardDecoratorContext cxt) {
        arrange(cxt);
        sut.mark(new Field(1, 2), Mark.John);

        assertMarkedFieldEquals(new Field(1, 2));
    }

    @ParameterizedTest
    @MethodSource("makeBoards")
    void IfJohnGetsMarked_ItShouldMarkJohnOnTheBoard(BoardDecoratorContext cxt) {
        arrange(cxt);
        sut.mark(new Field(0, 0), Mark.John);

        assertHasMarked(Mark.John);
    }

    @ParameterizedTest
    @MethodSource("makeBoards")
    void IfHaleyGetsMarked_ItShouldMarkHaleyOnTheBoard(BoardDecoratorContext cxt) {
        arrange(cxt);
        sut.mark(new Field(0, 0), Mark.Haley);

        assertHasMarked(Mark.Haley);
    }

    private void assertHasMarked(Mark expected) {
        Mark actual = decoree.getMark();
        assertEquals(expected, actual);
    }

    private void assertMarkedFieldEquals(Field expected) {
        Field actual = decoree.getMarkedField();
        assertEquals(expected, actual);
    }


}
