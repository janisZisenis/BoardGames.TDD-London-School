package Gaming.GameOverRules.WinnerRule;

import org.junit.jupiter.api.Test;

import static Gaming.GameOverRules.GameOverRuleAssertions.assertIsGameOver;
import static Gaming.GameOverRules.GameOverRuleAssertions.assertIsNotGameOver;

public class WinnerRuleTest {

    private HasWinnerProviderStub provider = new HasWinnerProviderStub();
    private WinnerRule sut = new WinnerRule(provider);

    @Test
    void IfHasWinner_GameShouldBeOver(){
        provider.setHasWinner(true);

        assertIsGameOver(sut);
    }

    @Test
    void IfHasNoWinner_GameShouldBeOver(){
        provider.setHasWinner(false);

        assertIsNotGameOver(sut);
    }


}
