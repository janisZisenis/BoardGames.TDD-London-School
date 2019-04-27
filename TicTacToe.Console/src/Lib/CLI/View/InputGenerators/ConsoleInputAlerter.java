package Lib.CLI.View.InputGenerators;

import Lib.Data.Input.Input;
import Lib.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp.InputAlerter;

public class ConsoleInputAlerter implements InputAlerter {

    private final String message;

    public ConsoleInputAlerter(String message) {
        this.message = message;
    }

    public void alert(Input input) {
        System.out.println(message);
    }
}
