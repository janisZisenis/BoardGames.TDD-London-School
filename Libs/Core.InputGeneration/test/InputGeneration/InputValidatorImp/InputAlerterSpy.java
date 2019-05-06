package InputGeneration.InputValidatorImp;

import InputGeneration.Input.Input;

public class InputAlerterSpy extends InputAlerterDummy {

    private Input alerted;
    private boolean didAlert = false;

    public Input getAlerted() {
        return alerted;
    }

    public void alert(Input input) {
        alerted = input;
        didAlert = true;
    }

    public boolean hasAlerted() {
        return didAlert;
    }
}
