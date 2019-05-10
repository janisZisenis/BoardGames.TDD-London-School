package Domain.Board.BoardDecorators;

import Domain.Board.BoardStub;
import Domain.Board.BoardDecorators.ListenableBoard.ListenableBoard;
import Domain.Data.Field.Field;
import Domain.Data.Mark;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BoardDecoratorTest {

    private BoardStub board = new BoardStub();
    private ListenableBoard sut = new ListenableBoard(board);

    @Test
    void IfR0C0IsEmptyOnTheBoard_R0C0ShouldBeEmptyEither() {
        makeFieldIsEmpty(new Field(0, 0));

        assertIsEmpty(new Field(0, 0));
    }

    @Test
    void IfR1C2IsEmptyOnTheBoard_R1C2ShouldBeEmptyEither() {
        makeFieldIsEmpty(new Field(1, 2));

        assertIsEmpty(new Field(1, 2));
    }

    @Test
    void IfR0C0IsNotEmptyOnTheBoard_R0C0ShouldBeNotEmptyEither() {
        assertIsNotEmpty(new Field(0, 0));
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
        board.setEmptyFields(fields);
    }


    @Test
    void IfR0C0IsMarkedOnTheBoard_R0C0ShouldBeMarkedEither() {
        makeFieldIsMarked(new Field(0, 0));

        assertIsMarked(new Field(0, 0));
    }

    @Test
    void IfR1C2IsMarkedOnTheBoard_R1C2ShouldBeMarkedEither() {
        makeFieldIsMarked(new Field(1, 2));

        assertIsMarked(new Field(1, 2));
    }

    @Test
    void IfFieldIsNotMarkedOnTheBoard_ItShouldBeNotMarkedEither() {
        assertIsNotMarked(new Field(0, 0));
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
        board.setMarkedFields(fields);
    }


    @Test
    void IfBoardHasHaleyOnR0C0_ItShouldHaveHaleyOnR0C0Either() {
        board.setMarkOnField(Mark.Haley, new Field(0, 0));

        assertHasHaleyOn(new Field(0, 0));
    }

    @Test
    void IfBoardHasJohnOnR0C0_ItHaveJohnOnR0C0Either() {
        board.setMarkOnField(Mark.John, new Field(0, 0));

        assertHasJohnOn(new Field(0, 0));
    }

    @Test
    void IfBoardHasJohnOnR1C2_ItHaveJohnOnR1C2Either() {
        board.setMarkOnField(Mark.John, new Field(1, 2));

        assertHasJohnOn(new Field(1, 2));
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


    @Test
    void IfBoardHasNoMarkedFields_ItShouldHaveNoMarkedFieldsEither() {
        board.setMarkedFieldCount(0);

        assertMarkedFieldCountIs(0);
    }

    @Test
    void IfBoardHasOneMarkedFields_ItShouldHaveOneMarkedFieldsEither() {
        board.setMarkedFieldCount(1);

        assertMarkedFieldCountIs(1);
    }

    private void assertMarkedFieldCountIs(int expected) {
        int actual = sut.getMarkedFieldCount();
        assertEquals(expected, actual);
    }


    @Test
    void IfR0C0GetsMarked_ItShouldMarkR0C0OnTheBoard() {
        sut.mark(new Field(0, 0), Mark.John);

        assertMarkedFieldEquals(new Field(0, 0));
    }

    @Test
    void IfR1C2GetsMarked_ItShouldMarkR1C2OnTheBoard() {
        sut.mark(new Field(1, 2), Mark.John);

        assertMarkedFieldEquals(new Field(1, 2));
    }

    @Test
    void IfJohnGetsMarked_ItShouldMarkJohnOnTheBoard() {
        sut.mark(new Field(0, 0), Mark.John);

        assertHasMarked(Mark.John);
    }

    @Test
    void IfHaleyGetsMarked_ItShouldMarkHaleyOnTheBoard() {
        sut.mark(new Field(0, 0), Mark.Haley);

        assertHasMarked(Mark.Haley);
    }

    private void assertHasMarked(Mark expected) {
        Mark actual = board.getMark();
        assertEquals(expected, actual);
    }

    private void assertMarkedFieldEquals(Field expected) {
        Field actual = board.getMarkedField();
        assertEquals(expected, actual);
    }


}
