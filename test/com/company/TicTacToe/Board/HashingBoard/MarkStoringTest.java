package com.company.TicTacToe.Board.HashingBoard;

import com.company.TicTacToe.Board.Board;
import com.company.TicTacToe.Board.Field.Field;
import com.company.TicTacToe.Board.Mark;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class MarkStoringTest {

    private HashingBoard sut = new HashingBoard();
    private Field first = new Field(0, 1);
    private Field second = new Field(1, 2);
    private Field third = new Field(1, 1);

    @Test
    void FreshInstance_gettingAMark_ShouldThrowException() {
        Executable act = () -> sut.getMarkAt(first);

        assertThrows(Board.FieldIsNotMarked.class, act);
    }

    @Test
    void IfJohnMarksField_ItShouldBeJohns() {
        sut.mark(first, Mark.John);

        assertIsJohns(first);
    }

    @Test
    void IfHaleyMarksField_ItShouldBeHaleys() {
        sut.mark(first, Mark.Haley);

        assertIsHaleys(first);
    }

    @Test
    void IfJohnMarksSecondAfterHaleyMarkedFirst_FirstFieldShouldBeHaleys() {
        makeHaleyMarkedFirst();

        sut.mark(second, Mark.John);

        assertIsHaleys(first);
    }

    @Test
    void IfHaleyMarksSecondAfterJohnMarkedFirst_SecondFieldShouldBeHaleys() {
        makeJohnMarkedFirst();

        sut.mark(second, Mark.Haley);

        assertIsHaleys(second);
    }

    @Test
    void IfJohnMarksThirdAfterHaleyMarkedSecondAndJohnMarkedFirst_SecondFieldShouldBeHaleys() {
        makeJohnMarkedFirstAndHaleyMarkedSecond();

        sut.mark(third, Mark.John);

        assertIsHaleys(second);
    }

    @Test
    void IfJohnMarksThirdAfterHaleyMarkedSecondAndJohnMarkedFirst_ThirdFieldShouldBeJohns() {
        makeJohnMarkedFirstAndHaleyMarkedSecond();

        sut.mark(third, Mark.John);

        assertIsJohns(third);
    }

    @Test
    void IfHaleyMarksThirdAfterJohnMarkedSecondAndHaleyMarkedFirst_ThirdFieldShouldBeHaleys() {
        makeHaleyMarkedFirstAndJohnMarkedSecond();

        sut.mark(third, Mark.Haley);

        assertIsHaleys(third);
    }


    private void makeHaleyMarkedFirst() {
        sut.mark(first, Mark.Haley);
    }

    private void makeJohnMarkedFirst() {
        sut.mark(first, Mark.John);
    }

    private void makeJohnMarkedFirstAndHaleyMarkedSecond() {
        makeJohnMarkedFirst();
        sut.mark(second, Mark.Haley);
    }

    private void makeHaleyMarkedFirstAndJohnMarkedSecond() {
        makeHaleyMarkedFirst();
        sut.mark(second, Mark.John);
    }


    private void assertIsJohns(Field f) {
        assertFieldHasMark(first, Mark.John);
    }

    private void assertIsHaleys(Field f) {
        assertFieldHasMark(f, Mark.Haley);
    }

    private void assertFieldHasMark(Field first, Mark x) {
        Mark actual = sut.getMarkAt(first);
        Mark expected = x;
        assertEquals(expected, actual);
    }

}