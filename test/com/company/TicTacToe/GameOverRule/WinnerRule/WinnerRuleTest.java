package com.company.TicTacToe.GameOverRule.WinnerRule;

import com.company.TicTacToe.Field.Field;
import com.company.TicTacToe.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinnerRuleTest {

    private LineProviderStub provider = new LineProviderStub();
    private LineEvaluatorStub evaluator = new LineEvaluatorStub();
    private WinnerRule sut = new WinnerRule(provider, evaluator);

    @Test
    void IfLineProviderHasNoLines_GameShouldHaveNoWinnerLine(){
        boolean actual = sut.hasWinner();

        assertFalse(actual);
    }

    @Test
    void IfLineProviderHas1WinningLine_GameShouldHaveAWinnerLine(){
        makeProviderHas1WinningLine();

        boolean actual = sut.hasWinner();

        assertTrue(actual);
    }

    @Test
    void IfLineProviderHas1NotWinningLine_GameShouldHaveNoWinnerLine(){
        makeProviderHas1NotWinningLine();

        boolean actual = sut.hasWinner();

        assertFalse(actual);
    }

    @Test
    void IfLineProviderHas2WinningLines_GameShouldHaveWinnerLine(){
        makeProviderHas2WinningLines();

        boolean actual = sut.hasWinner();

        assertTrue(actual);
    }

    @Test
    void IfLineProviderHas2NotWinningLines_GameShouldNotHaveWinnerLine(){
        makeProviderHas2NotWinningLines();

        boolean actual = sut.hasWinner();

        assertFalse(actual);
    }

    @Test
    void IfLineProviderHas1NotWinningAnd1WinningLine_GameShouldHaveWinnerLine(){
        makeProviderHasOneNotWinningAndOneWinningLine();

        boolean actual = sut.hasWinner();

        assertTrue(actual);
    }

    private void makeProviderHas2WinningLines() {
        Line first = new Line(new Field(0, 0), new Field(0, 1), new Field(0, 2));
        Line second = new Line(new Field(1, 0), new Field(1, 1), new Field(1, 2));
        provider.setLines(new Line[] { first, second });
        evaluator.setWinningLines(new Line[]{ first, second });
    }

    private void makeProviderHas1WinningLine() {
        Line line = new Line(new Field(0, 0), new Field(0, 1), new Field(0, 2));
        provider.setLines(new Line[] { line });
        evaluator.setWinningLines(new Line[]{ line });
    }

    private void makeProviderHas1NotWinningLine() {
        Line line = new Line(new Field(0, 0), new Field(0, 1), new Field(0, 2));
        provider.setLines(new Line[] { line });
        evaluator.setWinningLines(new Line[]{ });
    }

    private void makeProviderHas2NotWinningLines() {
        Line first = new Line(new Field(0, 0), new Field(0, 1), new Field(0, 2));
        Line second = new Line(new Field(1, 0), new Field(1, 1), new Field(1, 2));
        provider.setLines(new Line[] { first, second });
        evaluator.setWinningLines(new Line[]{});
    }

    private void makeProviderHasOneNotWinningAndOneWinningLine() {
        Line first = new Line(new Field(0, 0), new Field(0, 1), new Field(0, 2));
        Line second = new Line(new Field(1, 0), new Field(1, 1), new Field(1, 2));
        provider.setLines(new Line[] { first, second });
        evaluator.setWinningLines(new Line[]{ second });
    }
}
