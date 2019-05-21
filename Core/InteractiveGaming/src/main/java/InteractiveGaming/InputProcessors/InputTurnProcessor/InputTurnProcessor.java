package InteractiveGaming.InputProcessors.InputTurnProcessor;

import Input2D.Input.Input;
import Input2D.InputProcessor;

public class InputTurnProcessor implements InputProcessor {

    private final InputProcessor processor;
    private final IsInputTurnProvider provider;

    public InputTurnProcessor(InputProcessor processor, IsInputTurnProvider provider) {
        this.processor = processor;
        this.provider = provider;
    }

    public void process(Input input) {
        if(provider.isInputTurn())
            processor.process(input);
    }
}
