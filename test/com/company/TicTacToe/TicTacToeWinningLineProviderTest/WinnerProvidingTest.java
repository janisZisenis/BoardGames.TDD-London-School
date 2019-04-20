package com.company.TicTacToe.TicTacToeWinningLineProviderTest;

import com.company.TicTacToe.Board.Mark;
import com.company.TicTacToe.BoardPresenter.WinningLineProvider;
import com.company.TicTacToe.GameOverRules.WinningLineRule.LineEvaluatorStub;
import com.company.TicTacToe.GameOverRules.WinningLineRule.LineProviderStub;
import com.company.TicTacToe.TicTacToeWinningLineProvider.TicTacToeWinningLineProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class WinnerProvidingTest {

    private LineProviderStub provider = new LineProviderStub();
    private LineEvaluatorStub evaluator = new LineEvaluatorStub();
    private TicTacToeWinningLineProvider sut = new TicTacToeWinningLineProvider(provider, evaluator);

    private WinningLinesConfigurator configurator = new WinningLinesConfigurator(provider, evaluator);

    @Test
    void IfNoLinesAreProvided_ShouldNotHaveAWinner(){
        boolean actual = sut.hasWinner();

        assertFalse(actual);
    }

    @Test
    void IfFirstProvidedLineIsWinning_ShouldHaveAWinner(){
        configurator.makeFirstProvidedLineIsWinning();

        boolean actual = sut.hasWinner();

        assertTrue(actual);
    }

    @Test
    void IfFirstProvidedLineIsNotWinning_ShouldNotHaveAWinner(){
        configurator.makeFirstProvidedLineIsNotWinning();

        boolean actual = sut.hasWinner();

        assertFalse(actual);
    }

    @Test
    void IfSecondProvidedLineIsWinningWhileFirstIsNot_ShouldHaveAWinningLine(){
        configurator.makeSecondProvidedLineIsWinningWhileFirstIsNot();

        boolean actual = sut.hasWinner();

        assertTrue(actual);
    }

    @Test
    void IfTwoNotWinningLinesAreProvided_ShouldNotHaveAWinner(){
        configurator.makeTwoNotWinningLinesAreProvided();

        boolean actual = sut.hasWinner();

        assertFalse(actual);
    }


    @Test
    void IfNoLinesAreProvided_GettingTheWinnerShouldThrow() {
        Executable act = () -> sut.getWinner();

        assertThrows(WinningLineProvider.NoWinnerAvailable.class, act);
    }

    @Test
    void IfJohnWinsWithFirstLine_ShouldProvideJohnAsWinner() {
        configurator.makeJohnWinsWithFirstLine();

        Mark actual = sut.getWinner();

        Mark expected = Mark.John;
        assertEquals(expected, actual);
    }

    @Test
    void IfHaleyWinsWithFirstLine_ShouldProvideHaleyAsWinner() {
        configurator.makeHaleyWinsWithFirstLine();

        Mark actual = sut.getWinner();

        Mark expected = Mark.Haley;
        assertEquals(expected, actual);
    }

    @Test
    void IfFirstProvidedLineIsNotWinning_GettingTheWinnerShouldThrow() {
        configurator.makeFirstProvidedLineIsNotWinning();

        Executable act = () -> sut.getWinner();

        assertThrows(WinningLineProvider.NoWinnerAvailable.class, act);
    }

    @Test
    void IfJohnWinsWithSecondLine_ShouldProvideJohnAsWinner() {
        configurator.makeJohnWinsWithSecondLine();

        Mark actual = sut.getWinner();

        Mark expected = Mark.John;
        assertEquals(expected, actual);
    }

    @Test
    void IfHalyeWinsWithSecondLine_ShouldProvideHaleyAsWinner() {
        configurator.makeHaleyWinsWithSecondLine();

        Mark actual = sut.getWinner();

        Mark expected = Mark.Haley;
        assertEquals(expected, actual);
    }

    @Test
    void IfTwoNotWinningLinesAreProvided_GettingTheWinnerShouldThrow() {
        configurator.makeTwoNotWinningLinesAreProvided();

        Executable act = () -> sut.getWinner();

        assertThrows(WinningLineProvider.NoWinnerAvailable.class, act);
    }

}
