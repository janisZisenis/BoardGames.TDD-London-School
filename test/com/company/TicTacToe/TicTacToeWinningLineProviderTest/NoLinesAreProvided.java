package com.company.TicTacToe.TicTacToeWinningLineProviderTest;

import com.company.TicTacToe.BoardPresenter.WinningLineProvider;
import com.company.TicTacToe.GameOverRules.WinningLineRule.LineEvaluatorStub;
import com.company.TicTacToe.GameOverRules.WinningLineRule.LineProviderStub;
import com.company.TicTacToe.TicTacToeWinningLineProvider.TicTacToeWinningLineProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

public class NoLinesAreProvided {

    private LineProviderStub provider = new LineProviderStub();
    private LineEvaluatorStub evaluator = new LineEvaluatorStub();
    private TicTacToeWinningLineProvider sut = new TicTacToeWinningLineProvider(provider, evaluator);

    @Test
    void IfNoLinesAreProvided_ShouldNotHaveAWinner(){
        boolean actual = sut.hasWinner();

        assertFalse(actual);
    }

    @Test
    void IfNoLinesAreProvided_GettingTheWinnerShouldThrow() {
        Executable act = () -> sut.getWinner();

        assertThrows(WinningLineProvider.NoWinnerAvailable.class, act);
    }

    @Test
    void IfNoLinesAreAvailable_ShouldNotHaveAWinningLine(){
        boolean actual = sut.hasWinningLine();

        assertFalse(actual);
    }

    @Test
    void IfNoLinesAreProvided_GettingTheWinningLineShouldThrow() {
        Executable act = () -> sut.getWinningLine();

        assertThrows(WinningLineProvider.NoWinningLineAvailable.class, act);
    }

}
