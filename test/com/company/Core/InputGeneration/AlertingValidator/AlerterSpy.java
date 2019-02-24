package com.company.Core.InputGeneration.AlertingValidator;

public class AlerterSpy implements Alerter {
    String alerted = "";

    public String getAlertedMessage() {
        return alerted;
    }

    public void alert(String message) {
        this.alerted = message;
    }
}
