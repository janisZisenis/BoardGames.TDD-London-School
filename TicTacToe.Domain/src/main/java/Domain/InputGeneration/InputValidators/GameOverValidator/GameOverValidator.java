package Domain.InputGeneration.InputValidators.GameOverValidator;

import InputGeneration.Input.Input;
import InputGeneration.ValidInputGenerator.InputValidator;
import SequentialGaming.DelegatingGame.GameOverRule;

public class GameOverValidator implements InputValidator {

    private final GameOverRule rule;

    public GameOverValidator(GameOverRule rule) {
        this.rule = rule;
    }

    public boolean isValid(Input input) {
        return !rule.isGameOver();
    }
}
