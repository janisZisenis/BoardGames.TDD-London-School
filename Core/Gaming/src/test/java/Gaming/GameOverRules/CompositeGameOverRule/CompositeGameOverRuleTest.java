package Gaming.GameOverRules.CompositeGameOverRule;

import Gaming.GameFacade.GameOverRuleStub;
import org.junit.jupiter.api.Test;

import static Gaming.Assertions.GameOverRuleAssertions.assertIsGameOver;
import static Gaming.Assertions.GameOverRuleAssertions.assertIsNotGameOver;

public class CompositeGameOverRuleTest {

    private CompositeGameOverRule sut = new CompositeGameOverRule();

    @Test
    void FreshInstance_GameShouldBeOver() {
        assertIsGameOver(sut);
    }

    @Test
    void AddedNotTerminatingRule_GameShouldNotBeOver() {
        makeNotTerminatingRuleIsAdded();

        assertIsNotGameOver(sut);
    }

    @Test
    void AddedTerminatingRule_GameShouldBeOver() {
        makeTerminatingRuleIsAdded();

        assertIsGameOver(sut);
    }

    @Test
    void AddedTerminatingAndNotTerminatingRule_GameShouldBeOver() {
        makeTerminatingRuleIsAdded();
        makeNotTerminatingRuleIsAdded();

        assertIsGameOver(sut);
    }

    @Test
    void AddedNotTerminatingAndTerminatingRule_GameShouldBeOver() {
        makeNotTerminatingRuleIsAdded();
        makeTerminatingRuleIsAdded();

        assertIsGameOver(sut);
    }

    @Test
    void AddedTerminatingBetweenTwoNotTerminatingRules_GameShouldBeOver() {
        makeNotTerminatingRuleIsAdded();
        makeTerminatingRuleIsAdded();
        makeNotTerminatingRuleIsAdded();

        assertIsGameOver(sut);
    }

    @Test
    void AddedTerminatingAfterTwoNotTerminatingRules_GameShouldBeOver() {
        makeNotTerminatingRuleIsAdded();
        makeNotTerminatingRuleIsAdded();
        makeTerminatingRuleIsAdded();

        assertIsGameOver(sut);
    }


    private void makeTerminatingRuleIsAdded() {
        GameOverRuleStub rule = new GameOverRuleStub();
        rule.setIsGameOver(true);
        sut.add(rule);
    }

    private void makeNotTerminatingRuleIsAdded() {
        GameOverRuleStub rule = new GameOverRuleStub();
        rule.setIsGameOver(false);
        sut.add(rule);
    }
}
