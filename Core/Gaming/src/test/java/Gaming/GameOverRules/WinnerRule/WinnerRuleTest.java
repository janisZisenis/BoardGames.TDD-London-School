package Gaming.GameOverRules.WinnerRule;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinnerRuleTest {

    private HasWinnerProviderStub provider = new HasWinnerProviderStub();
    private WinnerRule sut = new WinnerRule(provider);

    @Test
    void IfHasWinner_GameShouldBeOver(){
        provider.setHasWinner(true);

        boolean actual = sut.isGameOver();

        assertTrue(actual);
    }

    @Test
    void IfHasNoWinner_GameShouldBeOver(){
        provider.setHasWinner(false);

        boolean actual = sut.isGameOver();

        assertFalse(actual);
    }


}
