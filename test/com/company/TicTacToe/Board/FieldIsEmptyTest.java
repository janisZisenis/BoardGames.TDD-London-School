package com.company.TicTacToe.Board;

import com.company.TicTacToe.Field;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FieldIsEmptyTest {

    private TicTacToeBoard sut = new TicTacToeBoard();
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
        markThreeFields();

        boolean actual = sut.isEmpty(third);
        assertFalse(actual);
    }


    private void makeOneFieldMarked() {
        sut.mark(first, Player.John);
    }

    private void makeTwoFieldsMarked() {
        makeOneFieldMarked();
        sut.mark(second, Player.John);
    }

    private void markThreeFields() {
        makeTwoFieldsMarked();
        sut.mark(third, Player.John);
    }

}
