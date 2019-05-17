package FXView;

import InputGeneration.Input.Input;
import InputGeneration.ValidInputGenerator.InputAlerter;

public class ConsoleInputAlerter implements InputAlerter {

    private final String message;

    public ConsoleInputAlerter(String message) {
        this.message = message;
    }

    public void alert(Input input) {
        System.out.println(message);
    }
}
