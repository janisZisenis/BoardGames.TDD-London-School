package com.company.TicTacToe.TicTacToeWinningLineProviderTest;

import com.company.TicTacToe.Board.Field.Field;
import com.company.TicTacToe.GameOverRules.WinningLineRule.LineEvaluatorStub;
import com.company.TicTacToe.GameOverRules.WinningLineRule.LineProviderStub;
import com.company.TicTacToe.Line;
import com.company.TicTacToe.TicTacToeWinningLineProvider.TicTacToeWinningLineProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WinnerProvidingTest {

    private LineProviderStub provider = new LineProviderStub();
    private LineEvaluatorStub evaluator = new LineEvaluatorStub();
    private TicTacToeWinningLineProvider sut = new TicTacToeWinningLineProvider(provider, evaluator);

    private Line[] lines = {};

    @Test
    void IfNoLinesAreAvailable_ShouldNotHaveAWinner(){
        boolean actual = sut.hasWinner();

        assertFalse(actual);
    }

    @Test
    void IfFirstLineIsWinning_ShouldHaveAWinner(){
        makeFirstLineIsWinning();

        boolean actual = sut.hasWinner();

        assertTrue(actual);
    }

    @Test
    void IfFirstLineIsNotWinning_ShouldNotHaveAWinner(){
        makeFirstLineIsNotWinning();

        boolean actual = sut.hasWinner();

        assertFalse(actual);
    }

    @Test
    void IfSecondLineIsWinning_ShouldHaveAWinningLine(){
        makeFirstLineIsNotWinningWhileSecondIs();

        boolean actual = sut.hasWinner();

        assertTrue(actual);
    }

    @Test
    void IfTwoNotWinningLinesAreProvided_ShouldNotHaveAWinner(){
        makeTwoNotWinningLinesAreProvided();

        boolean actual = sut.hasWinner();

        assertFalse(actual);
    }



    private void makeFirstLineIsNotWinning() {
        initializeOneLine();
        provider.setLines(lines);
        evaluator.setWinningLines(new Line[]{ });
    }

    private void makeFirstLineIsWinning() {
        initializeOneLine();
        provider.setLines(lines);
        evaluator.setWinningLines(lines);
    }

    private void initializeOneLine() {
        Line first = makeFirstLine();
        lines = new Line[]{ first };
    }

    private Line makeFirstLine() {
        Field first = new Field(0, 0);
        Field second = new Field(0, 1);
        Field third = new Field(0, 2);

        return new Line(first, second, third);
    }

    private void makeFirstLineIsNotWinningWhileSecondIs() {
        initializeTwoLines();
        provider.setLines(new Line[] { lines[0], lines[1] });
        evaluator.setWinningLines(new Line[]{ lines[1] });
    }

    private Line makeSecondLine() {
        Field first = new Field(1, 0);
        Field second = new Field(1, 1);
        Field third = new Field(1, 2);

        return new Line(first, second, third);
    }

    private void initializeTwoLines() {
        Line first = makeFirstLine();
        Line second = makeSecondLine();
        lines = new Line[]{ first, second };
    }

    private void makeTwoNotWinningLinesAreProvided() {
        Line first = makeFirstLine();
        Line second = makeSecondLine();
        provider.setLines(new Line[] { first, second });
        evaluator.setWinningLines(new Line[]{});
    }
}
