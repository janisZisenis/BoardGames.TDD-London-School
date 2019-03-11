package com.company.CLI.InputGeneration;

import com.company.Core.Rules.AlertingRule.Alerter;

public class ConsoleAlerter implements Alerter {

    private final String message;

    public ConsoleAlerter(String message) {
        this.message = message;
    }

    public void alert() {
        System.out.println(message);
    }
}
