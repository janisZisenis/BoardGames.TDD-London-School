package com.company.CLI.InputGeneration;

import com.company.Core.InputGeneration.Input.Input;
import com.company.Core.InputGeneration.InputAlerter.InputAlerter;

public class ConsoleInputAlerter implements InputAlerter {

    private final String message;

    public ConsoleInputAlerter(String message) {
        this.message = message;
    }

    public void alert(Input input) {
        System.out.println(message);
    }
}
