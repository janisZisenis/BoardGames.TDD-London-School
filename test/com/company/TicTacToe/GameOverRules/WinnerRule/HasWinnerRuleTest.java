package com.company.TicTacToe.GameOverRules.WinnerRule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HasWinnerRuleTest {

    @Test
    void IfHasWinner_GameShouldBeOver(){
        HasWinnerProviderStub provider = new HasWinnerProviderStub();
        HasWinnerRule sut = new HasWinnerRule(provider);
        provider.setHasWinner(true);

        boolean actual = sut.isGameOver();

        assertTrue(actual);
    }

    @Test
    void IfHasNoWinner_GameShouldBeOver(){
        HasWinnerProviderStub provider = new HasWinnerProviderStub();
        HasWinnerRule sut = new HasWinnerRule(provider);
        provider.setHasWinner(false);

        boolean actual = sut.isGameOver();

        assertFalse(actual);
    }


}
