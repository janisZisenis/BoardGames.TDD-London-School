package Lib.GameEvaluation.EquallyMarkedLineEvaluator;

import Api.MarkedFieldProviderStub;
import Board.Mark;
import Data.Field.Field;
import Data.Line.Line;
import Lib.GameEvaluation.GameEvaluator.LineEvaluator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class EquallyMarkedLineEvaluatorTest {


    private MarkedFieldProviderStub provider = new MarkedFieldProviderStub();
    private EquallyMarkedLineEvaluator sut = new EquallyMarkedLineEvaluator(provider);

    private Field first = new Field(0, 1);
    private Field second = new Field(0, 2);
    private Field third = new Field(0, 3);
    private Line line = new Line(first, second, third);

    @Test
    void IfLineIsEquallyMarked_ItShouldBeTheWinningLine() {
        makeLineIsEquallyMarkedWith(Mark.John);

        boolean actual = sut.isWinningLine(line);

        assertTrue(actual);
    }

    @Test
    void IfLineIsNotEquallyMarked_ItShouldNotBeTheWinningLine() {
        makeLineIsNotEquallyMarked();

        boolean actual = sut.isWinningLine(line);

        assertFalse(actual);
    }

    @Test
    void IfFirstOfLineIsNotMarked_ItShouldNotBeTheWinningLine() {
        makeFirstOfLineIsNotMarked();

        boolean actual = sut.isWinningLine(line);

        assertFalse(actual);
    }

    @Test
    void IfSecondOfLineIsNotMarked_ItShouldNotBeTheWinningLine() {
        makeSecondOfLineIsNotMarked();

        boolean actual = sut.isWinningLine(line);

        assertFalse(actual);
    }

    @Test
    void IfThirdOfLineIsNotMarked_ItShouldNotBeTheWinningLine() {
        makeThirdOfLineIsNotMarked();

        boolean actual = sut.isWinningLine(line);

        assertFalse(actual);
    }




    @Test
    void IfFirstOfLineIsNotMarked_GettingTheWinnerShouldThrow() {
        makeFirstOfLineIsNotMarked();

        Executable act = () -> sut.getWinner(line);

        assertThrows(LineEvaluator.NoWinnerForLineAvailable.class, act);
    }

    @Test
    void IfLineIsEquallyMarkedWithJohn_JohnShouldBeTheWinner() {
        makeLineIsEquallyMarkedWith(Mark.John);

        Mark actual = sut.getWinner(line);

        Mark expected = Mark.John;
        assertEquals(expected, actual);
    }

    @Test
    void IfLineIsEquallyMarkedWithHaley_HaleyShouldBeTheWinner() {
        makeLineIsEquallyMarkedWith(Mark.Haley);

        Mark actual = sut.getWinner(line);

        Mark expected = Mark.Haley;
        assertEquals(expected, actual);
    }

    @Test
    void IfSecondOfLineIsNotMarked_GettingTheWinnerShouldThrow() {
        makeSecondOfLineIsNotMarked();

        Executable act = () -> sut.getWinner(line);

        assertThrows(LineEvaluator.NoWinnerForLineAvailable.class, act);
    }

    @Test
    void IfThirdOfLineIsNotMarked_GettingTheWinnerShouldThrow() {
        makeThirdOfLineIsNotMarked();

        Executable act = () -> sut.getWinner(line);

        assertThrows(LineEvaluator.NoWinnerForLineAvailable.class, act);
    }

    @Test
    void IfLineIsNotEquallyMarked_GettingTheWinnerShouldThrow() {
        makeLineIsNotEquallyMarked();

        Executable act = () -> sut.getWinner(line);

        assertThrows(LineEvaluator.NoWinnerForLineAvailable.class, act);
    }



    private void makeLineIsEquallyMarkedWith(Mark m) {
        provider.addMarkedField(first, m);
        provider.addMarkedField(second, m);
        provider.addMarkedField(third, m);
    }

    private void makeLineIsNotEquallyMarked() {
        provider.addMarkedField(first, Mark.Haley);
        provider.addMarkedField(second, Mark.John);
        provider.addMarkedField(third, Mark.Haley);
    }

    private void makeFirstOfLineIsNotMarked() {
        provider.addMarkedField(second, Mark.John);
        provider.addMarkedField(third, Mark.Haley);
    }

    private void makeSecondOfLineIsNotMarked() {
        provider.addMarkedField(first, Mark.John);
        provider.addMarkedField(third, Mark.Haley);
    }

    private void makeThirdOfLineIsNotMarked() {
        provider.addMarkedField(first, Mark.John);
        provider.addMarkedField(second, Mark.Haley);
    }

}
