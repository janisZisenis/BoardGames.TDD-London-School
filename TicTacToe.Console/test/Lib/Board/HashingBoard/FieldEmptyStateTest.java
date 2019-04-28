package Lib.Board.HashingBoard;

import Lib.Data.Field.Field;
import Lib.Data.Mark;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldEmptyStateTest {

    private HashingBoard sut = new HashingBoard();
    private Field first = new Field(1, 2);
    private Field second = new Field(0, 1);
    private Field third = new Field(2, 1);

    @Test
    void FreshInstance_FieldShouldBeEmpty() {
        boolean actual = sut.isEmpty(first);
        assertTrue(actual);
    }

    @Test
    void IfOneFieldIsMarked_ItShouldNotBeEmpty() {
        makeOneFieldMarked();

        boolean actual = sut.isEmpty(first);
        assertFalse(actual);
    }

    @Test
    void IfOneFieldIsMarked_ASecondFieldShouldBeEmpty() {
        makeOneFieldMarked();

        boolean actual = sut.isEmpty(second);
        assertTrue(actual);
    }

    @Test
    void IfTwoFieldsAreMarked_FirstFieldShouldNotBeEmpty() {
        makeTwoFieldsMarked();

        boolean actual = sut.isEmpty(first);
        assertFalse(actual);
    }

    @Test
    void IfTwoFieldsAreMarked_SecondFieldShouldNotBeEmpty() {
        makeTwoFieldsMarked();

        boolean actual = sut.isEmpty(second);
        assertFalse(actual);
    }

    @Test
    void IfTwoFieldsAreMarked_ThirdFieldShouldBeEmpty() {
        makeTwoFieldsMarked();

        boolean actual = sut.isEmpty(third);
        assertTrue(actual);
    }

    @Test
    void IfThreeFieldsAreMarked_ThirdFieldShouldNotBeEmpty() {
        makeThreeFieldsMarked();

        boolean actual = sut.isEmpty(third);
        assertFalse(actual);
    }

    @Test
    void FreshInstance_FieldShouldBeNotBeMarked() {
        boolean actual = sut.isMarked(first);
        assertFalse(actual);
    }

    @Test
    void IfOneFieldIsMarked_ItShouldBeMarked() {
        makeOneFieldMarked();

        boolean actual = sut.isMarked(first);
        assertTrue(actual);
    }


    private void makeOneFieldMarked() {
        sut.mark(first, Mark.John);
    }

    private void makeTwoFieldsMarked() {
        makeOneFieldMarked();
        sut.mark(second, Mark.John);
    }

    private void makeThreeFieldsMarked() {
        makeTwoFieldsMarked();
        sut.mark(third, Mark.John);
    }

}
