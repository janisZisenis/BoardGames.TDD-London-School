package com.company.TicTacToe.TicTacToeWinningLineProviderTest;

import com.company.TicTacToe.GameOverRules.WinningLineRule.LineEvaluatorStub;
import com.company.TicTacToe.GameOverRules.WinningLineRule.LineProviderStub;
import com.company.TicTacToe.TicTacToeWinningLineProvider.TicTacToeWinningLineProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

}
