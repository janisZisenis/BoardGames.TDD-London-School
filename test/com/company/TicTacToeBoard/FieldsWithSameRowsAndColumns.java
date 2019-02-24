package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidator.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldsWithSameRowsAndColumns {

    TicTacToeBoard sut = new TicTacToeBoard();
    Field field = new Field(1, 1);
    Field similar = new Field(1, 1);

    @Test
    void IfFieldGetsMarked_ASimilarFieldShouldNotBeEmpty() {
        sut.mark(field, Player.John);

        boolean actual = sut.isEmpty(similar);
        assertFalse(actual);
    }

    @Test
    void IfAFieldGetsMarked_SimilarFieldShouldHaveTheSameMark() {
        sut.mark(field, Player.John);

        Player actual = sut.getMarkAt(similar);
        Player expected = Player.John;
        assertEquals(expected, actual);
    }

}
