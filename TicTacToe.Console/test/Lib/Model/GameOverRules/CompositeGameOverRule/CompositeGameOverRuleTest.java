package Lib.Model.GameOverRules.CompositeGameOverRule;

import Lib.Model.RenderingGameLoop.GameImp.GameOverRuleStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CompositeGameOverRuleTest {

    private CompositeGameOverRule sut = new CompositeGameOverRule();

    @Test
    void FreshInstance_GameShouldBeOver() {
        boolean actual = sut.isGameOver();

        assertTrue(actual);
    }

    @Test
    void AddedNotTerminatingGameOverRule_GameShouldNotBeOver() {
        makeNotTerminatingRuleAdded();

        boolean actual = sut.isGameOver();

        assertFalse(actual);
    }

    @Test
    void AddedTerminatingRule_GameShouldBeOver() {
        makeTerminatingRuleAdded();

        boolean actual = sut.isGameOver();

        assertTrue(actual);
    }

    @Test
    void AddedTerminatingAndNotTerminatingRule_GameShouldBeOver() {
        makeTerminatingRuleAdded();
        makeNotTerminatingRuleAdded();

        boolean actual = sut.isGameOver();

        assertTrue(actual);
    }

    @Test
    void AddedNotTerminatingAndTerminatingRule_GameShouldBeOver() {
        makeNotTerminatingRuleAdded();
        makeTerminatingRuleAdded();

        boolean actual = sut.isGameOver();

        assertTrue(actual);
    }

    @Test
    void AddedTerminatingBetweenTwoNotTerminatingRules_GameShouldBeOver() {
        makeNotTerminatingRuleAdded();
        makeTerminatingRuleAdded();
        makeNotTerminatingRuleAdded();

        boolean actual = sut.isGameOver();

        assertTrue(actual);
    }

    @Test
    void AddedTerminatingAfterTwoNotTerminatingRules_GameShouldBeOver() {
        makeNotTerminatingRuleAdded();
        makeNotTerminatingRuleAdded();
        makeTerminatingRuleAdded();

        boolean actual = sut.isGameOver();

        assertTrue(actual);
    }

    private void makeTerminatingRuleAdded() {
        GameOverRuleStub first = new GameOverRuleStub();
        first.setGameIsOver(true);
        sut.add(first);
    }

    private void makeNotTerminatingRuleAdded() {
        GameOverRuleStub first = new GameOverRuleStub();
        first.setGameIsOver(false);
        sut.add(first);
    }
}
