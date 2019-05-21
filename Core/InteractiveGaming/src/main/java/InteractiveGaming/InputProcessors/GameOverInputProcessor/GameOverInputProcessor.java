package InteractiveGaming.InputProcessors.GameOverInputProcessor;

import Gaming.GameFacade.GameOverRule;
import Input2D.Input.Input;
import Input2D.InputProcessor;

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
