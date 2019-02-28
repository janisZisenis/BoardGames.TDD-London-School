package com.company.TicTacToe.Board;

import com.company.TicTacToe.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldsWithSameRowsAndColumns {

    private TicTacToeBoard sut = new TicTacToeBoard();
    private Field field = new Field(1, 1);
    private Field similar = new Field(1, 1);

    @Test
    void IfFieldGetsMarked_ASimilarFieldShouldNotBeEmpty() {
        sut.mark(field, Mark.John);

        boolean actual = sut.isEmpty(similar);
        assertFalse(actual);
    }

    @Test
    void IfAFieldGetsMarked_SimilarFieldShouldHaveTheSameMark() {
        sut.mark(field, Mark.John);

        Mark actual = sut.getMarkAt(similar);
        Mark expected = Mark.John;
        assertEquals(expected, actual);
    }

}
