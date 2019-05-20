package Gaming.Assertions;

import Gaming.GameFacade.GameOverRule;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class GameOverRuleAssertions {

    public static void assertIsNotGameOver(GameOverRule rule) {
        boolean actual = rule.isGameOver();
        assertFalse(actual);
    }

    public static void assertIsGameOver(GameOverRule rule) {
        boolean actual = rule.isGameOver();
        assertTrue(actual);
    }

}
