package com.company.CLI.InputGeneration;

import com.company.Core.InputGeneration.AlertingValidator.Alerter;

public class ConsoleAlerter implements Alerter {

    public void alert(String message) {
        System.out.println(message);
    }
}
