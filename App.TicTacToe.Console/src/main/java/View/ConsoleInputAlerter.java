package View;

import InputGeneration.Input.Input;
import InputGeneration.ValidatingInputGenerator.AlertingInputGenerator.InputAlerter;

public class ConsoleInputAlerter implements InputAlerter {

    private final String message;

    public ConsoleInputAlerter(String message) {
        this.message = message;
    }

    public void alert(Input input) {
        System.out.println(message);
    }
}
