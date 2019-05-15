package Domain.GameOverInputProcessor;

import Gaming.GameFacade.GameOverRule;
import InputGeneration.Input.Input;
import InputGeneration.InputProcessor;

public class GameOverInputProcessor implements InputProcessor {

    private final InputProcessor processor;
    private final GameOverRule rule;

    public GameOverInputProcessor(InputProcessor processor, GameOverRule rule) {
        this.rule = rule;
        this.processor = processor;
    }

    public void process(Input input) {
        if(!rule.isGameOver())
            processor.process(input);
    }

}
