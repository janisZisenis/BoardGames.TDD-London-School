package SequentialRendering.BoardRenderer;

import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProviderStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RenderingTheBoardTest {

    private BoardViewSpy view = new BoardViewSpy();
    private WinningLineProviderStub provider = new WinningLineProviderStub();
    private BoardRenderer sut = new BoardRenderer(view, provider);

    @Test
    void IfNoWinningLineIsProvided_ShouldShowTheBoard() {
        makeNoWinningLineIsProvided();

        sut.render();

        boolean actual = view.hasShownBoard();
        assertTrue(actual);
    }

    @Test
    void IfWinningLineIsProvided_ShouldNotShowTheBoard() {
        makeWinningLineIsProvided();

        sut.render();

        boolean actual = view.hasShownBoard();
        assertFalse(actual);
    }

    @Test
    void IfWinningLineIsProvided_ShouldShowTheWinningLine() {
        Line line = new Line(new Field(0, 1), new Field(1, 1), new Field(1, 2));
        provider.setWinningLine(line);

        sut.render();

        Line actual = view.getShownWinnineLine();
        Line expected = line;
        assertEquals(expected, actual);
    }

    @Test
    void IfNoWinningLineIsProvided_ShouldNotShowTheWinningLine() {
        makeNoWinningLineIsProvided();

        sut.render();

        boolean actual = view.hasShownWinningLine();
        assertFalse(actual);
    }

    private void makeNoWinningLineIsProvided() {
        provider.setWinningLine(null);
    }

    private void makeWinningLineIsProvided() {
        Line line = makeLine();
        provider.setWinningLine(line);
    }

    private Line makeLine() {
        Field first = new Field(0, 0);
        Field second = new Field(1, 1);
        Field third = new Field(1, 2);

        return new Line(first, second, third);
    }

}
