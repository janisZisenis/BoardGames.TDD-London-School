package com.company;

import com.company.AlertingValidator.Alerter;

public class ConsoleAlerter implements Alerter {

    public void alert(String message) {
        System.out.println(message);
    }
}
