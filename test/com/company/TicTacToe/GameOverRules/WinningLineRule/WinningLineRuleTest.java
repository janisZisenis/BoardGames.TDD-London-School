package com.company.TicTacToe.GameOverRules.WinningLineRule;

import com.company.TicTacToe.Board.Field.Field;
import com.company.TicTacToe.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinningLineRuleTest {

    private LineProviderStub provider = new LineProviderStub();
    private LineEvaluatorStub evaluator = new LineEvaluatorStub();
    private WinningLineRule sut = new WinningLineRule(provider, evaluator);

    @Test
    void IfLineProviderHasNoLines_GameShouldNotBeOver(){
        boolean actual = sut.isGameOver();

        assertFalse(actual);
    }

    @Test
    void IfLineProviderHas1WinningLine_GameShouldBeOver(){
        makeProviderHas1WinningLine();

        boolean actual = sut.isGameOver();

        assertTrue(actual);
    }

    @Test
    void IfLineProviderHas1NotWinningLine_GameShouldNotBeOver(){
        makeProviderHas1NotWinningLine();

        boolean actual = sut.isGameOver();

        assertFalse(actual);
    }

    @Test
    void IfLineProviderHas2WinningLines_GameShouldBeOver(){
        makeProviderHas2WinningLines();

        boolean actual = sut.isGameOver();

        assertTrue(actual);
    }

    @Test
    void IfLineProviderHas2NotWinningLines_GameShouldNotBeOver(){
        makeProviderHas2NotWinningLines();

        boolean actual = sut.isGameOver();

        assertFalse(actual);
    }

    @Test
    void IfLineProviderHas1NotWinningAnd1WinningLine_GameShouldBeOver(){
        makeProviderHasOneNotWinningAndOneWinningLine();

        boolean actual = sut.isGameOver();

        assertTrue(actual);
    }

    private void makeProviderHas1WinningLine() {
        Line line = new Line(new Field(0, 0), new Field(0, 1), new Field(0, 2));
        provider.setProvidedLines(new Line[] { line });
        evaluator.setWinningLines(new Line[]{ line });
    }

    private void makeProviderHas1NotWinningLine() {
        Line line = new Line(new Field(0, 0), new Field(0, 1), new Field(0, 2));
        provider.setProvidedLines(new Line[] { line });
        evaluator.setWinningLines(new Line[]{ });
    }

    private void makeProviderHas2WinningLines() {
        Line first = new Line(new Field(0, 0), new Field(0, 1), new Field(0, 2));
        Line second = new Line(new Field(1, 0), new Field(1, 1), new Field(1, 2));
        provider.setProvidedLines(new Line[] { first, second });
        evaluator.setWinningLines(new Line[]{ first, second });
    }

    private void makeProviderHas2NotWinningLines() {
        Line first = new Line(new Field(0, 0), new Field(0, 1), new Field(0, 2));
        Line second = new Line(new Field(1, 0), new Field(1, 1), new Field(1, 2));
        provider.setProvidedLines(new Line[] { first, second });
        evaluator.setWinningLines(new Line[]{});
    }

    private void makeProviderHasOneNotWinningAndOneWinningLine() {
        Line first = new Line(new Field(0, 0), new Field(0, 1), new Field(0, 2));
        Line second = new Line(new Field(1, 0), new Field(1, 1), new Field(1, 2));
        provider.setProvidedLines(new Line[] { first, second });
        evaluator.setWinningLines(new Line[]{ second });
    }
}
