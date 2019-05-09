package InputGeneration;

import InputGeneration.Input.Input;
import InputGeneration.InputProcessor;

public class InputProcessorSpy implements InputProcessor {

    private Input processed = null;
    private boolean didProcess = false;

    public Input getProcessed() {
        return processed;
    }
    public void process(Input input) {
        didProcess = true;
        processed = input;
    }

    public boolean hasProcessed() {
        return didProcess;
    }
}
