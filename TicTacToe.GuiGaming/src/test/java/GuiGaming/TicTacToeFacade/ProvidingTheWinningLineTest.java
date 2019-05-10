package GuiGaming.TicTacToeFacade;

import Domain.Data.Field.Field;
import Domain.Data.Line.Line;
import Domain.GameEvaluation.GameEvaluator.Api.WinningLineProviderStub;
import Domain.GameEvaluation.EquallyMarkedLineEvaluator.MarkedFieldProviderDummy;
import InputGeneration.InputProcessorDummy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProvidingTheWinningLineTest {

    private WinningLineProviderStub provider = new WinningLineProviderStub();
    private InputProcessorDummy processor = new InputProcessorDummy();
    private MarkedFieldProviderDummy markedFieldProvider = new MarkedFieldProviderDummy();
    private TicTacToeFacade sut = new TicTacToeFacade(provider, processor, markedFieldProvider);

    @Test
    void IfWinningLineIsProvided_ShouldHaveAWinner() {
        Line line = makeLine();
        provider.setWinningLine(line);

        assertHasWinner();
    }

    @Test
    void IfNoWinningLineIsProvided_ShouldNotHaveAWinner() {
        provider.setWinningLine(null);

        assertHasNoWinner();
    }

    @Test
    void IfWinningLineIsProvided_ShouldProvideTheSameWinningLine() {
        Line line = makeLine();
        provider.setWinningLine(line);

        assertWinningLineEquals(line);
    }

    private void assertWinningLineEquals(Line expected) {
        Line actual = sut.getWinningLine();
        assertEquals(expected, actual);
    }

    private void assertHasWinner() {
        boolean actual = sut.hasWinner();
        assertTrue(actual);
    }

    private void assertHasNoWinner() {
        boolean actual = sut.hasWinner();
        assertFalse(actual);
    }

    private Line makeLine() {
        return new Line(new Field(0, 0), new Field(0, 1), new Field(1, 1));
    }
}
