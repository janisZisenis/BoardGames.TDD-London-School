package Domain.InputGeneration.InputValidators.GameOverValidator;

import InputGeneration.Input.Input;
import SequentialGaming.DelegatingGame.GameOverRuleStub;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameOverValidatorTest {

    @Test
    void IfGameIsOver_TheInputShouldBeInvalid() {
        GameOverRuleStub rule = new GameOverRuleStub();
        rule.setIsGameOver(true);
        GameOverValidator sut = new GameOverValidator(rule);
        Input input = new Input(0, 0);

        boolean actual = sut.isValid(input);

        assertFalse(actual);
    }

    @Test
    void IfGameIsNotOver_TheInputShouldBeValid() {
        GameOverRuleStub rule = new GameOverRuleStub();
        rule.setIsGameOver(false);
        GameOverValidator sut = new GameOverValidator(rule);
        Input input = new Input(0, 0);

        boolean actual = sut.isValid(input);

        assertTrue(actual);
    }

}
