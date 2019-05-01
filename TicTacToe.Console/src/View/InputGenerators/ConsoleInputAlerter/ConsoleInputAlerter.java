package View.InputGenerators.ConsoleInputAlerter;

import Lib.Data.Input.Input;
import Lib.InputGenerators.AlertingInputGenerator.InputValidatorImp.InputAlerter;

public class ConsoleInputAlerter implements InputAlerter {

    private final String message;

    public ConsoleInputAlerter(String message) {
        this.message = message;
    }

    public void alert(Input input) {
        System.out.println(message);
    }
}
