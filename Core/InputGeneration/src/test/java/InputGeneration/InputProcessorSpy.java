package InputGeneration;

import InputGeneration.Input.Input;

public class InputProcessorSpy extends InputProcessorDummy {

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
