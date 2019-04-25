package com.company.CLI.View.Core.InputGeneration;

import com.company.Data.Input.Input;
import com.company.Model.InputGenerators.VerboseValidatingInputGenerator.InputRefereeImp.InputAlerter;

public class ConsoleInputAlerter implements InputAlerter {

    private final String message;

    public ConsoleInputAlerter(String message) {
        this.message = message;
    }

    public void alert(Input input) {
        System.out.println(message);
    }
}
