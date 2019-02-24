package com.company.TicTacToeBoard;

import com.company.IsOnBoardValidatorImp.Field;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FieldHasExistingRowAndColumn {

    Field field = new Field(1, 1);
    TicTacToeBoard sut = new TicTacToeBoard();

    @Test
    void IfRowAndColumnExists_FieldShouldExist() {
        boolean actual = sut.exists(field);

        assertTrue(actual);
    }

}
