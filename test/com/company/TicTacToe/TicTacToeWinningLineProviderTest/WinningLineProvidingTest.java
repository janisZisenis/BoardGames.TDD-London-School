package com.company.TicTacToe.TicTacToeWinningLineProviderTest;

import com.company.TicTacToe.BoardPresenter.WinningLineProvider;
import com.company.TicTacToe.GameOverRules.WinningLineRule.LineEvaluatorStub;
import com.company.TicTacToe.GameOverRules.WinningLineRule.LineProviderStub;
import com.company.TicTacToe.Line;
import com.company.TicTacToe.TicTacToeWinningLineProvider.TicTacToeWinningLineProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class WinningLineProvidingTest {

    private LineProviderStub provider = new LineProviderStub();
    private LineEvaluatorStub evaluator = new LineEvaluatorStub();
    private TicTacToeWinningLineProvider sut = new TicTacToeWinningLineProvider(provider, evaluator);

    private WinningLinesConfigurator configurator = new WinningLinesConfigurator(provider, evaluator);

    @Test
    void IfNoLinesAreAvailable_ShouldNotHaveAWinningLine(){
        boolean actual = sut.hasWinningLine();

        assertFalse(actual);
    }

    @Test
    void IfFirstProvidedLineIsWinning_ShouldHaveAWinningLine(){
        configurator.makeFirstProvidedLineIsWinning();

        boolean actual = sut.hasWinningLine();

        assertTrue(actual);
    }

    @Test
    void IfFirstProvidedLineIsNotWinning_ShouldNotHaveAWinningLine(){
        configurator.makeFirstProvidedLineIsNotWinning();

        boolean actual = sut.hasWinningLine();

        assertFalse(actual);
    }

    @Test
    void IfSecondProvidedLineIsWinningWhileFirstIsNot_ShouldHaveAWinningLine(){
        configurator.makeSecondProvidedLineIsWinningWhileFirstIsNot();

        boolean actual = sut.hasWinningLine();

        assertTrue(actual);
    }

    @Test
    void IfTwoNotWinningLinesAreProvided_ShouldNotHaveAWinningLine(){
        configurator.makeTwoNotWinningLinesAreProvided();

        boolean actual = sut.hasWinningLine();

        assertFalse(actual);
    }



    @Test
    void IfNoLinesAreProvided_GettingTheWinningLineShouldThrowException() {
        Executable act = () -> sut.getWinningLine();

        assertThrows(WinningLineProvider.NoWinningLineAvailable.class, act);
    }

    @Test
    void IfFirstProvidedLineIsWinning_ShouldProvideTheFirstLine() {
        configurator.makeFirstProvidedLineIsWinning();

        Line actual = sut.getWinningLine();

        Line expected = configurator.getProvidedLine(0);
        assertEquals(expected, actual);
    }

    @Test
    void IfFirstProvidedLineIsNotWinning_GettingTheWinningLineShouldThrowException() {
        configurator.makeFirstProvidedLineIsNotWinning();

        Executable act = () -> sut.getWinningLine();

        assertThrows(WinningLineProvider.NoWinningLineAvailable.class, act);
    }

    @Test
    void IfSecondProvidedLineIsWinningWhileFirstIsNot_ShouldProvideTheSecondLine() {
        configurator.makeSecondProvidedLineIsWinningWhileFirstIsNot();

        Line actual = sut.getWinningLine();

        Line expected = configurator.getProvidedLine(1);
        assertEquals(expected, actual);
    }

    @Test
    void IfTwoNotWinningLinesAreProvided_GettingTheWinningLineShouldThrowException() {
        configurator.makeTwoNotWinningLinesAreProvided();

        Executable act = () -> sut.getWinningLine();

        assertThrows(WinningLineProvider.NoWinningLineAvailable.class, act);
    }

    @Test
    void IfTwoWinningLinesAreProvided_ShouldProvideTheFirst(){
        configurator.makeTwoWinningLinesAreProvided();

        Line actual = sut.getWinningLine();

        Line expected = configurator.getProvidedLine(0);
        assertEquals(expected, actual);
    }

}
