package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidator.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FieldMarkingTest {

    private TicTacToeBoard sut = new TicTacToeBoard();
    private Field first = new Field(0, 1);
    private Field second = new Field(1, 2);
    private Field third = new Field(1, 1);

    @Test
    void IfJohnMarksField_ItShouldBeJohns() {
        sut.mark(first, Player.John);

        assertIsJohns(first);
    }

    @Test
    void IfHaleyMarksField_ItShouldBeHaleys() {
        sut.mark(first, Player.Haley);

        assertIsHaleys(first);
    }

    @Test
    void IfJohnMarksSecondAfterHaleyMarkedFirst_FirstFieldShouldBeHaleys() {
        makeHaleyMarkedFirst();

        sut.mark(second, Player.John);

        assertIsHaleys(first);
    }

    @Test
    void IfHaleyMarksSecondAfterJohnMarkedFirst_SecondFieldShouldBeHaleys() {
        makeJohnMarkedFirst();

        sut.mark(second, Player.Haley);

        assertIsHaleys(second);
    }

    @Test
    void IfJohnMarksThirdAfterHaleyMarkedSecondAndJohnMarkedFirst_SecondFieldShouldBeHaleys() {
        makeJohnMarkedFirstAndHaleyMarkedSecond();

        sut.mark(third, Player.John);

        assertIsHaleys(second);
    }

    @Test
    void IfJohnMarksThirdAfterHaleyMarkedSecondAndJohnMarkedFirst_ThirdFieldShouldBeJohns() {
        makeJohnMarkedFirstAndHaleyMarkedSecond();

        sut.mark(third, Player.John);

        assertIsJohns(third);
    }

    @Test
    void IfHaleyMarksThirdAfterJohnMarkedSecondAndHaleyMarkedFirst_ThirdFieldShouldBeHaleys() {
        makeHaleyMarkedFirstAndJohnMarkedSecond();

        sut.mark(third, Player.Haley);

        assertIsHaleys(third);
    }


    private void makeHaleyMarkedFirst() {
        sut.mark(first, Player.Haley);
    }

    private void makeJohnMarkedFirst() {
        sut.mark(first, Player.John);
    }

    private void makeJohnMarkedFirstAndHaleyMarkedSecond() {
        makeJohnMarkedFirst();
        sut.mark(second, Player.Haley);
    }

    private void makeHaleyMarkedFirstAndJohnMarkedSecond() {
        makeHaleyMarkedFirst();
        sut.mark(second, Player.John);
    }


    private void assertIsJohns(Field f) {
        assertFieldHasMark(first, Player.John);
    }

    private void assertIsHaleys(Field f) {
        assertFieldHasMark(f, Player.Haley);
    }

    private void assertFieldHasMark(Field first, Player x) {
        Player actual = sut.getMarkAt(first);
        Player expected = x;
        assertEquals(expected, actual);
    }

}