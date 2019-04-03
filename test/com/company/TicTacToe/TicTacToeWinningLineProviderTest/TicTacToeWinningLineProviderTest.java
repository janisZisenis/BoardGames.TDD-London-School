package com.company.TicTacToe.TicTacToeWinningLineProviderTest;

import com.company.TicTacToe.Board.Field.Field;
import com.company.TicTacToe.BoardPresenter.WinningLineProvider;
import com.company.TicTacToe.GameOverRules.WinningLineRule.LineEvaluatorStub;
import com.company.TicTacToe.GameOverRules.WinningLineRule.LineProviderStub;
import com.company.TicTacToe.Line;
import com.company.TicTacToe.TicTacToeWinningLineProvider.TicTacToeWinningLineProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class TicTacToeWinningLineProviderTest {

    private LineProviderStub provider = new LineProviderStub();
    private LineEvaluatorStub evaluator = new LineEvaluatorStub();
    private TicTacToeWinningLineProvider sut = new TicTacToeWinningLineProvider(provider, evaluator);

    private Line[] lines = {};

    @Test
    void IfNoLinesAreAvailable_ShouldNotHaveAWinningLine(){
        boolean actual = sut.hasWinningLine();

        assertFalse(actual);
    }

    @Test
    void IfFirstLineIsWinning_ShouldHaveAWinningLine(){
        makeFirstLineIsWinning();

        boolean actual = sut.hasWinningLine();

        assertTrue(actual);
    }

    @Test
    void IfFirstLineIsNotWinning_ShouldNotHaveAWinningLine(){
        makeFirstLineIsNotWinning();

        boolean actual = sut.hasWinningLine();

        assertFalse(actual);
    }

    @Test
    void IfSecondLineIsWinning_ShouldHaveAWinningLine(){
        makeFirstLineIsNotWinningWhileSecondIs();

        boolean actual = sut.hasWinningLine();

        assertTrue(actual);
    }

    @Test
    void IfFirstLineIsWinningAndSecondNot_ShouldHaveAWinningLine(){
        makeFirstLineIsWinningWhileSecondIsNot();

        boolean actual = sut.hasWinningLine();

        assertTrue(actual);
    }

    @Test
    void IfTwoNotWinningLinesAreAvailable_ShouldNotHaveAWinningLine(){
        makeTwoNotWinningLinesAreAvailable();

        boolean actual = sut.hasWinningLine();

        assertFalse(actual);
    }



    @Test
    void IfNoLinesAreAvailable_GettingTheWinningLineShouldThrowException() {
        Executable act = () -> sut.getWinningLine();

        assertThrows(WinningLineProvider.NoWinningLineAvailable.class, act);
    }

    @Test
    void IfFirstLineIsWinning_ShouldProvideTheFirstLine() {
        makeFirstLineIsWinning();

        Line actual = sut.getWinningLine();

        Line expected = lines[0];
        assertEquals(expected, actual);
    }

    @Test
    void IfFirstLineIsNotWinning_GettingTheWinningLineShouldThrowException() {
        makeFirstLineIsNotWinning();

        Executable act = () -> sut.getWinningLine();

        assertThrows(WinningLineProvider.NoWinningLineAvailable.class, act);
    }

    @Test
    void IfSecondLineIsWinning_ShouldProvideTheSecondLine() {
        makeFirstLineIsNotWinningWhileSecondIs();

        Line actual = sut.getWinningLine();

        Line expected = lines[1];
        assertEquals(expected, actual);
    }

    @Test
    void IfTwoNotWinningLinesAreAvailable_GettingTheWinningLineShouldThrowException() {
        makeTwoNotWinningLinesAreAvailable();

        Executable act = () -> sut.getWinningLine();

        assertThrows(WinningLineProvider.NoWinningLineAvailable.class, act);
    }

    @Test
    void IfLineProviderHas2WinningLines_ShouldProvideTheFirst(){
        makeFirstAndSecondLineAreWinning();

        Line actual = sut.getWinningLine();

        Line expected = lines[0];
        assertEquals(expected, actual);
    }


    private void makeFirstLineIsWinning() {
        initializeOneLine();
        provider.setLines(lines);
        evaluator.setWinningLines(lines);
    }

    private void makeFirstLineIsNotWinning() {
        initializeOneLine();
        provider.setLines(lines);
        evaluator.setWinningLines(new Line[]{ });
    }

    private void makeFirstAndSecondLineAreWinning() {
        Line first = makeFirstLine();
        Line second = makeSecondLine();
        lines = new Line[]{ first, second };
        provider.setLines(lines);
        evaluator.setWinningLines(lines);
    }

    private void makeTwoNotWinningLinesAreAvailable() {
        Line first = makeFirstLine();
        Line second = makeSecondLine();
        provider.setLines(new Line[] { first, second });
        evaluator.setWinningLines(new Line[]{});
    }

    private void makeFirstLineIsNotWinningWhileSecondIs() {
        initializeTwoLines();
        provider.setLines(new Line[] { lines[0], lines[1] });
        evaluator.setWinningLines(new Line[]{ lines[1] });
    }

    private void makeFirstLineIsWinningWhileSecondIsNot() {
        initializeTwoLines();
        provider.setLines(new Line[] { lines[0], lines[1] });
        evaluator.setWinningLines(new Line[]{ lines[0] });
    }

    private Line makeFirstLine() {
        Field first = new Field(0, 0);
        Field second = new Field(0, 1);
        Field third = new Field(0, 2);

        return new Line(first, second, third);
    }

    private Line makeSecondLine() {
        Field first = new Field(1, 0);
        Field second = new Field(1, 1);
        Field third = new Field(1, 2);

        return new Line(first, second, third);
    }

    private void initializeOneLine() {
        Line first = makeFirstLine();
        lines = new Line[]{ first };
    }

    private void initializeTwoLines() {
        Line first = makeFirstLine();
        Line second = makeSecondLine();
        lines = new Line[]{ first, second };
    }
}
