package SequentialGaming.GameOverRules.WinnerRule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinnerRuleTest {

    @Test
    void IfHasWinner_GameShouldBeOver(){
        HasWinnerProviderStub provider = new HasWinnerProviderStub();
        WinnerRule sut = new WinnerRule(provider);
        provider.setHasWinner(true);

        boolean actual = sut.isGameOver();

        assertTrue(actual);
    }

    @Test
    void IfHasNoWinner_GameShouldBeOver(){
        HasWinnerProviderStub provider = new HasWinnerProviderStub();
        WinnerRule sut = new WinnerRule(provider);
        provider.setHasWinner(false);

        boolean actual = sut.isGameOver();

        assertFalse(actual);
    }


}
