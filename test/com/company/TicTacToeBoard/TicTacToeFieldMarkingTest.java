package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.MarkBits;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeFieldMarkingTest {
    @Test
    void FreshInstance_Row0Column0ShouldBeEmpty() {
        TicTacToeBoard sut = new TicTacToeBoard();
        Field field = new Field(0,0);

        TicTacToeBoard.Mark actual = sut.getMark(field);
        TicTacToeBoard.Mark expected = TicTacToeBoard.Mark.Empty;
        assertEquals(expected, actual);
    }

    @Test
    void IfRow0AndColumn0WasMarkedWithX_ShouldHaveStoredXAtRow0AndColumn0() {
        TicTacToeBoard sut = new TicTacToeBoard();
        Field field = new Field(0,0);

        sut.markField(field, TicTacToeBoard.Mark.X);

        TicTacToeBoard.Mark actual = sut.getMark(field);
        TicTacToeBoard.Mark expected = TicTacToeBoard.Mark.X;
        assertEquals(expected, actual);
    }

    @Test
    void IfRow0AndColumn0WasMarkedWithO_ShouldHaveStoredOAtRow0AndColumn0() {
        TicTacToeBoard sut = new TicTacToeBoard();
        Field field = new Field(0,0);

        sut.markField(field, TicTacToeBoard.Mark.O);

        TicTacToeBoard.Mark actual = sut.getMark(field);
        TicTacToeBoard.Mark expected = TicTacToeBoard.Mark.O;
        assertEquals(expected, actual);
    }
    
}
