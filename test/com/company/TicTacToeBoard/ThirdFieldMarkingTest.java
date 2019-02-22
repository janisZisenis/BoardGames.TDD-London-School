package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ThirdFieldMarkingTest {

    @Test
    void _2_2GetsMarkedAfter_0_0_And_1_1MarkedWithO_OShouldBeStoredAt_1_1() {
        TicTacToeBoard sut = new TicTacToeBoard();
        Field first = new Field(0, 0);
        Field second = new Field(1, 1);
        Field third = new Field(2, 2);
        sut.mark(first, Mark.X);
        sut.mark(second, Mark.O);

        sut.mark(third, Mark.X);

        Mark actual = sut.getMarkAt(second);
        Mark expected = Mark.O;
        assertEquals(expected, actual);
    }

//    @Test
//    void _2_2GetsMarkedAfter_0_0_And_1_1Marked_ItShouldNotBeEmpty() {
//        TicTacToeBoard sut = new TicTacToeBoard();
//        Field first = new Field(0, 0);
//        Field second = new Field(1, 1);
//        Field third = new Field(2, 2);
//        sut.mark(first, Mark.X);
//        sut.mark(second, Mark.O);
//
//        sut.mark(third, Mark.X);
//
//        boolean actual = sut.isEmpty(third);
//        assertFalse(actual);
//    }

}
