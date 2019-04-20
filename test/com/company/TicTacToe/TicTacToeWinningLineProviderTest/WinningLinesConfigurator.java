package com.company.TicTacToe.TicTacToeWinningLineProviderTest;

import com.company.TicTacToe.Board.Field.Field;
import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.GameOverRules.WinningLineRule.LineEvaluatorStub;
import com.company.TicTacToe.GameOverRules.WinningLineRule.LineProviderStub;
import com.company.TicTacToe.Line;

public class WinningLinesConfigurator {

    private final LineProviderStub provider;
    private final LineEvaluatorStub evaluator;

    private Line[] lines = {};

    public WinningLinesConfigurator(LineProviderStub provider, LineEvaluatorStub evaluator) {
        this.provider = provider;
        this.evaluator = evaluator;
    }

    public void makeFirstProvidedLineIsWinning() {
        initializeOneLine();
        provider.setProvidedLines(lines);
        evaluator.setWinningLines(lines);
    }

    public void makeFirstProvidedLineIsNotWinning() {
        initializeOneLine();
        provider.setProvidedLines(lines);
        evaluator.setWinningLines(new Line[]{ });
    }

    public void makeSecondProvidedLineIsWinningWhileFirstIsNot() {
        initializeTwoLines();
        provider.setProvidedLines(new Line[] { lines[0], lines[1] });
        evaluator.setWinningLines(new Line[]{ lines[1] });
    }

    public void makeTwoNotWinningLinesAreProvided() {
        initializeTwoLines();
        provider.setProvidedLines(new Line[] { lines[0] , lines[1] });
        evaluator.setWinningLines(new Line[]{});
    }

    public void makeTwoWinningLinesAreProvided() {
        initializeTwoLines();
        provider.setProvidedLines(new Line[] { lines[0] , lines[1] });
        evaluator.setWinningLines(new Line[]{ lines[0] , lines[1] });
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

    public void makeJohnWinsWithFirstLine() {
        makeFirstProvidedLineIsWinning();
        evaluator.setWinnerForLine(Mark.John, getProvidedLine(0));

    }

    public void makeHaleyWinsWithFirstLine() {
        makeFirstProvidedLineIsWinning();
        evaluator.setWinnerForLine(Mark.Haley, getProvidedLine(0));
    }

    public Line getProvidedLine(int index) {
        return lines[index];
    }

    public void makeJohnWinsWithSecondLine() {
        makeSecondProvidedLineIsWinningWhileFirstIsNot();
        evaluator.setWinnerForLine(Mark.John, getProvidedLine(1));
    }

    public void makeHaleyWinsWithSecondLine() {
        makeSecondProvidedLineIsWinningWhileFirstIsNot();
        evaluator.setWinnerForLine(Mark.Haley, getProvidedLine(1));
    }
}
